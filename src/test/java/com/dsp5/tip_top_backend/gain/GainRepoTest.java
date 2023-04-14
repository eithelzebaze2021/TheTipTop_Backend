package com.dsp5.tip_top_backend.gain;

import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.repository.GainRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


    @Test
    void findGainDispo() {
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
       // assertEquals(gain.getIdGain(),gainList.get(0));

        assertTrue(gainList.stream().findAny().isPresent());
       // assertEquals(gainList.get(0),gain);

    }

    @Test
    void findAllOrder() {
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
        List<Gain> gainList = gainRepo.findAllOrder();

        //then
        // assertEquals(gain.getIdGain(),gainList.get(0));

        assertTrue(gainList.stream().findAny().isPresent());
        // assertEquals(gainList.get(0),gain);
        assertEquals(gainList.equals(gain),gain.equals(gainRepo.findAllOrder()));
    }
}
