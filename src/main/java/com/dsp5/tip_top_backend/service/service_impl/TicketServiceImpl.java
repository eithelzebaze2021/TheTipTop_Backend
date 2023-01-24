package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.repository.GainRepo;
import com.dsp5.tip_top_backend.repository.TicketRepo;
import com.dsp5.tip_top_backend.service.GainService;
import com.dsp5.tip_top_backend.service.TicketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service @Transactional
public class TicketServiceImpl implements TicketService {

    private final Logger log = LogManager.getLogger("TICKET SERVICE");
    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private GainRepo gainRepo;

    @Autowired
    private GainService gainService;

    @Override
    public Ticket getTicketById(Long idTicket) {
        return ticketRepo.findById(idTicket).get();
    }

    @Override
    public Ticket saveTicket(Ticket t, List<Gain> listgainDispo) {

        Gain gainClient = attribuerGain(listgainDispo);

        gainClient.setNbreTicketRestant(gainClient.getNbreTicketRestant()-1);

        t.setIdGain(gainService.saveGain(gainClient).getIdGain());

        return ticketRepo.save(t);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> getAllTicketOfClient(Long idClient) {
        return ticketRepo.findByIdClient(idClient);
    }

    @Override
    public List<Ticket> getAllTicketOfGain(Long idGain) {
        return ticketRepo.findByIdGain(idGain);
    }

    @Override
    public Gain attribuerGain(List<Gain> listGain) {

        Random r = new Random();
        int n = r.nextInt(listGain.size());
        return listGain.get(n);
    }
}
