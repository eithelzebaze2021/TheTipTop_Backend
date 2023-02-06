package com.dsp5.tip_top_backend.gain;

import com.dsp5.tip_top_backend.repository.GainRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GainRepoTest {

    @Autowired
    private GainRepo gainRepo;

    @AfterEach
    void tearDown(){
        gainRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }

}
