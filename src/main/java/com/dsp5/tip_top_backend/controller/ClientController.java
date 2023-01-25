package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.service.ClientService;
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

    @GetMapping("/getAllClient")
    public ResponseEntity<List<Client>> getAllClient(){
        return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getClientById/{idC}")
    public ResponseEntity<Client>getClientById(@PathVariable("idC") Long idClient){
        return new ResponseEntity<>(clientService.getClientById(idClient), HttpStatus.ACCEPTED);
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
