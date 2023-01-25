package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.service.ClientService;
import com.dsp5.tip_top_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAllClient")
    public ResponseEntity<List<Client>> getAllClient(){
        return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.ACCEPTED);
    }

}
