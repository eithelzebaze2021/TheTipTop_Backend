package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.service.GainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/gain")
public class GainController {

    @Autowired
    private GainService gainService;

    @GetMapping("/getAllGain")
    public ResponseEntity<List<Gain>> getAllGain(){
        return new ResponseEntity<>(gainService.getAllGain(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getGainById/{idG}")
    public ResponseEntity<Gain>getGainById(@PathVariable("idG") Long idGain){
        return new ResponseEntity<>(gainService.getGainById(idGain), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveGain")
    public ResponseEntity<?>saveGain(@RequestBody Gain g){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/gain/saveGain").toUriString());
        return ResponseEntity.created(uri).build();

    }

}
