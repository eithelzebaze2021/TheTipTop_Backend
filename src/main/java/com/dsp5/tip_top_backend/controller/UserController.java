package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Boolean>saveUser(@RequestBody Utilisateur U){
        if(userService.saveUser(U)){
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

    }
}
