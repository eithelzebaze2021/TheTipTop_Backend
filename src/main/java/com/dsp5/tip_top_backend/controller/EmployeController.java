package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Employe;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.service.EmployeService;
import com.dsp5.tip_top_backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/employe")
public class EmployeController {

    @Autowired
    public EmployeService employeService;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/getEmployeByIdUser/{idU}")
    public ResponseEntity<Employe>getEmployeByIdUser(@PathVariable("idU") Long idU){
        return new ResponseEntity<>(employeService.getEmployeByIdUser(idU), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getEmployeConnect")
    public ResponseEntity<Employe>getEmployeConnect(){

        Utilisateur user = jwtUtils.getUserFromToken();

        return new ResponseEntity<>(employeService.getEmployeByIdUser(user.getIdUser()), HttpStatus.OK);
    }

    @GetMapping("/getAllEmploye")
    public ResponseEntity<List<Employe>>getAllEmploye(){

        Utilisateur user = jwtUtils.getUserFromToken();

        if(roleRepo.findStrRoleById(user.getIdRole()).equals("ROLE_ADMIN")){
            return new ResponseEntity<>(employeService.getAllEmploye(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(employeService.getAllEmploye(), HttpStatus.UNAUTHORIZED);
    }

}
