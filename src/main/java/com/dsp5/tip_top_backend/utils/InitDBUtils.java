package com.dsp5.tip_top_backend.utils;

import com.dsp5.tip_top_backend.model.*;
import com.dsp5.tip_top_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitDBUtils implements CommandLineRunner {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurRepo userRepo;

    @Autowired
    public RoleRepo roleRepo;

    @Autowired
    public ClientRepo clientRepo;

    @Autowired
    public EmployeRepo employeRepo;

    @Autowired
    public MagasinRepo magasinRepo;

    @Override
    public void run(String... args) throws Exception {

        //Init Role
        Role role1 = new Role(1,"ROLE_CLIENT");
        Role role2 = new Role(2,"ROLE_EMPLOYE");
        Role role3 = new Role(3,"ROLE_ADMIN");
        this.roleRepo.saveAll(Arrays.asList(role1,role2,role3));

        //Init user
        Utilisateur user1 = new Utilisateur(1,"Zebaze","Eithel","France",
                "95","eithel.zebaze@gmail.com", passwordEncoder.encode("1234"));
        Utilisateur user2 = new Utilisateur(1,"Fopa","Armelle","France",
                "93","armelle.fopa@gmail.com",passwordEncoder.encode("1234"));
        Utilisateur user3 = new Utilisateur(1,"Donna","Stephane","France",
                "75","stephane.donna@gmail.com",passwordEncoder.encode("1234"));
        Utilisateur user4 = new Utilisateur(2,"employe","employe","Nice",
                "75","employe@gmail.com",passwordEncoder.encode("1234"));
        Utilisateur user5 = new Utilisateur(3,"admin","admin","France",
                "75","admin@gmail.com",passwordEncoder.encode("1234"));
        this.userRepo.save(user5);

        //Init Client
        Client client1 = new Client(user1);
        Client client2 = new Client(user2);
        Client client3 = new Client(user3);
        this.clientRepo.saveAll(Arrays.asList(client1,client2,client3));

        //Init Magasin
        Magasin magasin1 = new Magasin("Dsp5Magasin","Vincenne", "94");

        //Init Employe
        Employe employe1 = new Employe(magasin1,user4);
        this.employeRepo.save(employe1);

    }
}
