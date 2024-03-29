package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.service.TicketService;
import com.dsp5.tip_top_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getAllTicketClient/{idClient}")
    public ResponseEntity<List<Ticket>> getAllTicketClient(@PathVariable("idClient") Long idClient){
        return new ResponseEntity<>(ticketService.getAllTicketOfClient(idClient), HttpStatus.ACCEPTED);
    }

   @GetMapping("/getAllTicketGain")
    public ResponseEntity<List<Ticket>> getAllTicketGain(){
        return new ResponseEntity<>(ticketService.getAllTicketOfGain(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveTicketMagasin")
    public ResponseEntity<Boolean> saveTicketMagasin(@RequestBody Ticket t){
        return new ResponseEntity<>(ticketService.saveTicketMagasin(t), HttpStatus.ACCEPTED);
    }

   @PostMapping("/saveTicketClient/{idClient}/{numTicket}")
    public ResponseEntity<Boolean> saveTicketClient(@PathVariable("idClient") Long idClient, @PathVariable("numTicket") String numTicket){
        return new ResponseEntity<>(ticketService.saveTicketClient(numTicket,idClient), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getTicketByIdMagasin/{idM}")
    public ResponseEntity<List<Ticket>>getTicketByIdMagasin(@PathVariable("idM") Long idM){
        return new ResponseEntity<>(ticketService.getTicketByIdMagasin(idM),HttpStatus.ACCEPTED);
    }

    @GetMapping("/updateTicket/{idT}")
    public ResponseEntity<Boolean>updateTicket(@PathVariable("idT") Long idT){

        Ticket ticketUpdate = ticketService.updateTicket(idT);

        if(ticketUpdate != null){
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api-tip-top-G1/ticket/updateTicket").toUriString());
            return ResponseEntity.created(uri).body(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }

    }

}
