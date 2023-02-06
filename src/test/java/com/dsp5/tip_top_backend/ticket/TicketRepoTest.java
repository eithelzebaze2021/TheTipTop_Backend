package com.dsp5.tip_top_backend.ticket;

import com.dsp5.tip_top_backend.repository.TicketRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TicketRepoTest {

    @Autowired
    private TicketRepo ticketRepo;

    @AfterEach
    void tearDown(){
        ticketRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }

    @Test
    public void findByIdClientTest(){

    }

    @Test
    public void findByIdGainTest(){

    }

    @Test
    public void findByNumTicketTest(){

    }
}
