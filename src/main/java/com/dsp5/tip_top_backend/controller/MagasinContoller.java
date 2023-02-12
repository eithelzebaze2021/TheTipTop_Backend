package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Magasin;
import com.dsp5.tip_top_backend.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/magasin")
public class MagasinContoller {

    @Autowired
    private MagasinService magasinService;

    @GetMapping("/getAllMagasin")
    public ResponseEntity<List<Magasin>> getAllMagasin(){
        return new ResponseEntity<>(magasinService.getAllMagasin(), HttpStatus.ACCEPTED);
    }

}
