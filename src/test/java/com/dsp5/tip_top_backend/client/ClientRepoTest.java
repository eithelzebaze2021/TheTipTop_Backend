package com.dsp5.tip_top_backend.client;
import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.ClientRepo;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ClientRepoTest {

    @Autowired
    private ClientRepo clientTest;
    @Autowired
    private RoleRepo roleTest;
    @Test
    void findByIdUser() {
        Role role = new Role(
                1,
                "client"
        );
        roleTest.save(role);

        //given
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
        clientTest.save(client);

        // when
        Optional<Client> clientOptional=clientTest.findByIdUser(utilisateur.getIdUser());

        //then
        assertTrue(clientOptional.isPresent());
        assertEquals(clientOptional.get(),client);
    }
}
