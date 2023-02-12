package com.dsp5.tip_top_backend.controller;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.service.TicketService;
import com.dsp5.tip_top_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-tip-top-G1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getAllTicketClient/{idClient}/{first}/{last}")
    public ResponseEntity<List<Ticket>> getAllTicketClient(@PathVariable("idClient") Long idClient,
                                                           @PathVariable("first") Integer first,
                                                           @PathVariable("last") Integer last){
        return new ResponseEntity<>(ticketService.getAllTicketOfClient(idClient,first,last), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllTicketGain/{first}/{last}")
    public ResponseEntity<List<Ticket>> getAllTicketGain(@PathVariable("first") Integer first,
                                                           @PathVariable("last") Integer last){
        return new ResponseEntity<>(ticketService.getAllTicketOfGain(first,last), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveTicketMagasin")
    public ResponseEntity<Boolean> saveTicketMagasin(@RequestBody Ticket t){
        return new ResponseEntity<>(ticketService.saveTicketMagasin(t), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveTicketClient/{numTicket}")
    public ResponseEntity<Boolean> saveTicketClient(@RequestBody Client c, @PathVariable("numTicket") String numTicket){
        return new ResponseEntity<>(ticketService.saveTicketClient(numTicket,c), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getTicketByIdMagasin/{idM}")
    public ResponseEntity<List<Ticket>>getTicketByIdMagasin(@PathVariable("idM") Long idM){
        return new ResponseEntity<>(ticketService.getTicketByIdMagasin(idM),HttpStatus.ACCEPTED);
    }

}
