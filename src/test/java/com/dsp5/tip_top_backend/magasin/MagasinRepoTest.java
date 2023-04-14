package com.dsp5.tip_top_backend.magasin;

import com.dsp5.tip_top_backend.repository.MagasinRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MagasinRepoTest {

    @Autowired
    private MagasinRepo magasinRepo;

    @AfterEach
    void tearDown(){
        magasinRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }


}
