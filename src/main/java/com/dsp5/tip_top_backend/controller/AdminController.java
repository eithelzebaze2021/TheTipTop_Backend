package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/getAllRole")
    public ResponseEntity<List<Role>> login(){
        return new ResponseEntity<>(adminService.getAllRole(),HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveRole")
    public ResponseEntity<Boolean>saveRole(@RequestBody Role r){

        if(adminService.saveRole(r)){
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/admin/saveRole").toUriString());
            return ResponseEntity.created(uri).body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

    @GetMapping("/getAllStrRole")
    public ResponseEntity<List<String>>getAllStrRole(){
        return new ResponseEntity<>(adminService.getAllStrRole(), HttpStatus.ACCEPTED);
    }

}
