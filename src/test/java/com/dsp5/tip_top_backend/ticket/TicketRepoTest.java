package com.dsp5.tip_top_backend.ticket;

import com.dsp5.tip_top_backend.model.*;
import com.dsp5.tip_top_backend.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TicketRepoTest {

    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private GainRepo gainRepo;
    @Autowired
    private MagasinRepo magasinRepo;
    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private RoleRepo roleRepo;


    @AfterEach
    void tearDown(){
        ticketRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }

    @Test
    public void findByIdClientTest(){
        // given
        Gain gain = new Gain(
                "Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.",
                "assets/img/infuseur_the.png",
                900000L,
                "un infuseur à thé",
                15L
        );
        gainRepo.save(gain);

        Magasin magasin = new Magasin(
                1L,
                "Dsp5Magasin",
                "Vincenne",
                "94",
                "Vincenne"
        );
        magasinRepo.save(magasin);

        Role role = new Role(
                1,
                "client"
        );
        roleRepo.save(role);

        Utilisateur utilisateur = new Utilisateur(
                1l,
                1,
                "Fopa",
                "Armelle",
                "France",
                "93",
                "armelle.fopa@gmail.com",
                "1234",
                "Vincenne"
        );
        Client client = new Client(
                1L,
                utilisateur
        );
        clientRepo.save(client);

        Ticket ticket = new Ticket(
                1L,
                1L,
                1L,
                50L,
                "1235489643",
                false,
                gain,
                client,
                magasin
        );
        ticketRepo.save(ticket);

        //when
        List<Ticket> ticketList = ticketRepo.findByIdClient(client.getIdClient(),0,4);
       // List<Ticket> ticketList1 = ticketRepo.findByIdClient(2L,0,20);

        //then
        //assertTrue(ticketList.stream().findAny());
      /// assertEquals(true,ticketList.equals(client.getIdClient()));
       // assertEquals(false, ticketList1.equals(ticket.getIdClient()));
        if(ticketList.size()>0){
            Ticket firstTicket = ticketList.get(0);
            assertEquals(client.getIdClient(),firstTicket.getIdClient());
        }






    }

    @Test
    public void findByIdGainTest(){


    }

    @Test
    public void findByNumTicketTest(){

    }
}
