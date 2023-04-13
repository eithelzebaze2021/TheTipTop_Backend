package com.dsp5.tip_top_backend.client;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.ClientRepo;
import com.dsp5.tip_top_backend.repository.GainRepo;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.repository.TicketRepo;
import com.dsp5.tip_top_backend.service.ClientService;
import com.dsp5.tip_top_backend.service.service_impl.ClientServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class ClientServiceImplTest {

    @Autowired private ClientRepo clientRepoTest;

    @Autowired private RoleRepo roleRepo;
    private ClientService clientService;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private GainRepo gainRepo;

    @Test
    void getClientByIdClient() {
        //given
        Role role = new Role(
                0,
                "ROLE_CLIENT"
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
        client = this.clientRepoTest.save(client);
        // when
        Client clientTest = this.clientService.getClientByIdClient(client.getIdClient());
        // then
        assertTrue(client.equals(clientTest));
    }
    @BeforeEach
    void setUp() {
       clientService = new ClientServiceImpl(clientRepoTest,ticketRepo,gainRepo);

    }
    @Test
    void getClientByIdUser() {

        //given
        Role role = new Role(
                0,
                "ROLE_CLIENT"
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
        client = this.clientRepoTest.save(client);
        // when
        Client clientTest = this.clientService.getClientByIdUser(client.getUser_client().getIdUser());
        // then
      //  verify(clientRepo.findById(client.getIdClient())).get();
        assertTrue(client.equals(clientTest));
    }

    @Test
    void saveClient() {
        //given
        Role role = new Role(
                0,
                "ROLE_CLIENT"
        );
        role = roleRepo.save(role);

        System.out.println("**************************************************"+role.getIdRole());

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
        client = this.clientRepoTest.save(client);
        //when
        Boolean clientTest1 = this.clientService.saveClient(client);
        //then
//        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
//        verify(clientRepoTest).save(clientArgumentCaptor.capture());
//
//        Client capturedClient = clientArgumentCaptor.getValue();
//        assertThat(capturedClient).isEqualTo(client);
       // assertTrue(client.equals(clientTest1));
        //assertEquals(clientRepoTest.save(client),clientTest1);
        assertThat(clientTest1).isTrue();
    }

    @Test
    void getAllClient() {
        //given
        Role role = new Role(
                0,
                "ROLE_CLIENT"
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
        client = this.clientRepoTest.save(client);

        //when
        List clientTest2 = this.clientService.getAllClient();
        //then
        assertEquals(clientTest2.get(0),client);

    }
}