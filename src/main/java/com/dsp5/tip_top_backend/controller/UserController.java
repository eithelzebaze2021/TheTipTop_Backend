package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.utils.JwtUtils;
import com.dsp5.tip_top_backend.utils.LoginRequest;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.service.UserService;
import com.dsp5.tip_top_backend.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<Utilisateur>>getAllUser(){

        UserDetails user = jwtUtils.getUserFromToken();

        if(user.getAuthorities().stream().toList().get(0).equals("ROLE_ADMIN")){
            return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("/getUserById/{idU}")
    public ResponseEntity<Utilisateur>getUserById(@PathVariable("idU") Long idUser){
        return new ResponseEntity<>(userService.getUserById(idUser), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Boolean>saveUser(@RequestBody Utilisateur u){

        if(userService.saveUser(u)){
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/user/saveUser").toUriString());
            return ResponseEntity.created(uri).body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

    @PutMapping("/updateUser")
    public ResponseEntity<Boolean>updateUser(@RequestBody Utilisateur u){

        Utilisateur userUpdate = userService.updateUser(u);

        if(userUpdate != null){
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/user/updateUser").toUriString());
            return ResponseEntity.created(uri).body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

    @PostMapping("/updateRoleUser/{idU}/{idR}")
    public ResponseEntity<Boolean>updateRoleUser(@PathVariable("idU") Long idUser,
                                                 @PathVariable("idR") Integer idRole){

        if(userService.updateRoleUser(idUser, idRole)){
            return ResponseEntity.ok().body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(userService.login(loginRequest),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllRoleForPublic")
    public ResponseEntity<List<String>> getAllRoleForPublic(){
        return new ResponseEntity<>(userService.getAllRoleForPublic(),HttpStatus.ACCEPTED);
    }

}
