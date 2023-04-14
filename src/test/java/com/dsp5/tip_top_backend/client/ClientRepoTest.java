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
    private ClientRepo clientRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Test
    void findByIdUser() {
        //given
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
        clientRepo.save(client);

        // when
        Optional<Client> clientOptional=clientRepo.findByIdUser(utilisateur.getIdUser());

        //then
        assertTrue(clientOptional.isPresent());
        assertEquals(clientOptional.get(),client);
    }
}
