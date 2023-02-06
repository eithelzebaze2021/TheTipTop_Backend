package com.dsp5.tip_top_backend.utilisateur;

import com.dsp5.tip_top_backend.repository.UtilisateurRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UtilisateurRepoTest {

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @AfterEach
    void tearDown(){
        utilisateurRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }

}
