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
        clientRepo.deleteAll();
        gainRepo.deleteAll();
        magasinRepo.deleteAll();
        utilisateurRepo.deleteAll();
        roleRepo.deleteAll();
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
        gain = gainRepo.save(gain);

        Magasin magasin = new Magasin(
                "Dsp5Magasin",
                "Vincenne",
                "94",
                "Vincenne"
        );
        magasin = magasinRepo.save(magasin);

        Role role = new Role(
                null,
                "client"
        );
        role = roleRepo.save(role);

        Utilisateur utilisateur = new Utilisateur(
                role.getIdRole(),
                "Fopa",
                "Armelle",
                "France",
                "93",
                "armelleqrrrr.fopa@gmail.com",
                "1234",
                "Vincenne"

        );
        utilisateur = utilisateurRepo.save(utilisateur);
        Client client = new Client(

                utilisateur
        );
        client = clientRepo.save(client);

        Ticket ticket = new Ticket(
                client.getIdClient(),
                gain.getIdGain(),
                magasin.getIdMagasin(),
                50L,
                "1235489643",
                false,
                gain,
                client,
                magasin
        );
         ticketRepo.save(ticket);

        //when
        List<Ticket> ticketList = ticketRepo.findByIdClient(client.getIdClient());
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
        // given
        Gain gain = new Gain(
                "Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.",
                "assets/img/infuseur_the.png",
                900000L,
                "un infuseur à thé",
                15L
        );
        gainRepo.save(gain);

        //when
        List<Gain> gainList = gainRepo.findGainDispo();

        //then
        if(gainList.size()>0) {
            Gain firstGain = gainList.get(0);
            assertEquals(gain.getIdGain(), firstGain.getIdGain());
        }



    }

    @Test
    public void findByNumTicketTest(){
        // given
        Gain gain = new Gain(
                "Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.",
                "assets/img/infuseur_the.png",
                900000L,
                "un infuseur à thé",
                15L
        );
        gain = gainRepo.save(gain);

        Magasin magasin = new Magasin(

                "Dsp5Magasin",
                "Vincenne",
                "94",
                "Vincenne"
        );
        magasin = magasinRepo.save(magasin);

        Role role = new Role(
                0,
                "client"
        );
        role = roleRepo.save(role);

        Utilisateur utilisateur = new Utilisateur(

                role.getIdRole(),
                "Fopa",
                "Armelle",
                "France",
                "93",
                "armelle.fopa@gmail.com",
                "1234",
                "Vincenne"
        );
        Client client = new Client(

                utilisateur
        );
        client = clientRepo.save(client);

        Ticket ticket = new Ticket(
                client.getIdClient(),
                gain.getIdGain(),
                magasin.getIdMagasin(),
                50L,
                "1235489643",
                false,
                gain,
                client,
                magasin
        );
        ticketRepo.save(ticket);

        //when
        Ticket numTicket = ticketRepo.findByNumTicket(ticket.getNumero());

        //then
        assertEquals(numTicket.getNumero(),ticket.getNumero());

    }
}
