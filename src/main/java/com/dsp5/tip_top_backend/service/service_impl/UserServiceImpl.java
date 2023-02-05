package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.service.ClientService;
import com.dsp5.tip_top_backend.utils.LoginRequest;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.repository.UtilisateurRepo;
import com.dsp5.tip_top_backend.service.UserService;
import com.dsp5.tip_top_backend.utils.JwtUtils;
import com.dsp5.tip_top_backend.utils.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LogManager.getLogger("USER SERVICE");

    @Autowired
    private UtilisateurRepo userRepo;

    @Autowired
    private ClientService clientService;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Utilisateur getUserById(Long idUser) {
        return userRepo.findById(idUser).get();
    }

    @Override
    public Utilisateur getUserByMail(String mail) {
        return userRepo.findByMail(mail).get();
    }

    @Override
    public Boolean saveUser(Utilisateur u) {

       Integer idRole = roleRepo.findIdRoleByStr(u.getRole());

       u.setPassword(passwordEncoder.encode(u.getPassword()));
       u.setIdRole(idRole);

       Utilisateur userSave = userRepo.save(u);

        if(userSave!=null){

            if(u.getRole().equals("ROLE_CLIENT")){
                Client clientSave = new Client(userSave);
                return clientService.saveClient(clientSave);
            }

            return true;

        }
        return false;
    }

    @Override
    public Boolean UpdateUserInfo(Utilisateur u) {

        Optional<Utilisateur> userBDrepo = userRepo.findById(u.getIdUser());

        if(userBDrepo.isPresent()){
            Utilisateur userBD = userBDrepo.get();
            userBD.setAdresse(u.getAdresse());
            userBD.setCode_postal(u.getCode_postal());
            userBD.setNom(u.getNom());
            userBD.setPrenom(u.getPrenom());
            userRepo.save(userBD);
            return true;
        }
        log.info("Utilisateur introuvable");
        return false;
    }

    @Override
    public Boolean UpdateUserIdentification(Long idUser, String mail, String password){
        Optional<Utilisateur> userBDrepo = userRepo.findById(idUser);

        if(userBDrepo.isPresent()){
           Utilisateur userBD = userBDrepo.get();

            userRepo.save(userBD);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateRoleUser(Long idUser, Integer idRole) {

        Utilisateur user = userRepo.findById(idUser).get();

        if(user != null){
            user.setIdRole(idRole);
            userRepo.save(user);
            return true;
        }

        return false;
    }

    @Override
    public List<Utilisateur> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse token = new LoginResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));
        Utilisateur user = userRepo.findByMail(loginRequest.getEmail()).orElseThrow( () -> new UsernameNotFoundException("User not found"));
        if(user != null){
            user.setRole(roleRepo.findStrRoleById(user.getIdRole()));
            token.setToken(jwtUtils.generateToken(user));
            token.setUser(user);
            return token;
        }
       return token;
    }

    @Override
    public List<String> getAllRoleForPublic() {
        return roleRepo.findAllStrRole();
    }

    @Bean
    public static AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
