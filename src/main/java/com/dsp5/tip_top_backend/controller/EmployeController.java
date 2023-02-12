package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Employe;
import com.dsp5.tip_top_backend.service.EmployeService;
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

    @GetMapping("/getEmployeByIdUser/{idU}")
    public ResponseEntity<Employe>getEmployeByIdUser(@PathVariable("idU") Long idU){
        return new ResponseEntity<>(employeService.getEmployeByIdUser(idU), HttpStatus.OK);
    }

    @GetMapping("/getAllEmploye")
    public ResponseEntity<List<Employe>>getAllEmploye(){
        return new ResponseEntity<>(employeService.getAllEmploye(), HttpStatus.OK);
    }

}
