package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.utils.LoginRequest;
import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<Utilisateur>>getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
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

    @PostMapping("/saveRole")
    public ResponseEntity<Boolean>saveRole(@RequestBody Role r){

        if(userService.saveRole(r)){
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/user/saveRole").toUriString());
            return ResponseEntity.created(uri).body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

    @PostMapping("/updateRoleUser/{idU}/{idR}")
    public ResponseEntity<Boolean>updateRoleUser(@PathVariable("idU") Long idUser,
                                                 @PathVariable("idR") Long idRole){

        if(userService.updateRoleUser(idUser, idRole)){
            return ResponseEntity.ok().body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.login(loginRequest));
    }


}
