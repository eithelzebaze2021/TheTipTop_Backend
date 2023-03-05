package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.service.ClientService;
import com.dsp5.tip_top_backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/getAllClient")
    public ResponseEntity<List<Client>> getAllClient(){

        Utilisateur user = jwtUtils.getUserFromToken();

        if(roleRepo.findStrRoleById(user.getIdRole()).equals("ROLE_ADMIN")){
            return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/getClientConnect")
    public ResponseEntity<Client>getClientConnect(){

        Utilisateur user = jwtUtils.getUserFromToken();

        return new ResponseEntity<>(clientService.getClientByIdUser(user.getIdUser()), HttpStatus.OK);
    }

    @GetMapping("/getClientByIdClient/{idC}")
    public ResponseEntity<Client>getClientByIdClient(@PathVariable("idC") Long idClient){
        return new ResponseEntity<>(clientService.getClientByIdClient(idClient), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getClientByIdUser/{idU}")
    public ResponseEntity<Client>getClientByIdUser(@PathVariable("idU") Long idUser){
        return new ResponseEntity<>(clientService.getClientByIdUser(idUser), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveClient")
    public ResponseEntity<Boolean>saveClient(@RequestBody Client c){

        if(clientService.saveClient(c)){
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/client/saveClient").toUriString());
            return ResponseEntity.created(uri).body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

}
