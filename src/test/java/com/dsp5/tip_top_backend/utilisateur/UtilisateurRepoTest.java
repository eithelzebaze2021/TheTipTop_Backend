package com.dsp5.tip_top_backend.utilisateur;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.repository.UtilisateurRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UtilisateurRepoTest {

    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private RoleRepo roleRepo;

    @AfterEach
    void tearDown(){
        utilisateurRepo.deleteAll();
        roleRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }

    @Test
    void findByMail() {
        Role role = new Role(
                0,
                "client"
        );
        role = roleRepo.save(role);

        //given
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
        utilisateur = utilisateurRepo.save(utilisateur);

        // when
        Optional<Utilisateur> utilisateurOptional=utilisateurRepo.findByMail(utilisateur.getMail());

        //then
        assertTrue(utilisateurOptional.isPresent());
         assertEquals(utilisateurOptional.get().getMail(),utilisateur.getMail());


    }
}
