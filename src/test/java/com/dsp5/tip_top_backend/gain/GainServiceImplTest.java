package com.dsp5.tip_top_backend.gain;

import com.dsp5.tip_top_backend.repository.GainRepo;
import com.dsp5.tip_top_backend.service.service_impl.GainServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class GainServiceImplTest {
    @Mock private GainRepo gainRepo;
    private GainServiceImpl gainService;

    @BeforeEach
    void setUp(){
        gainService = new GainServiceImpl(gainRepo);
    }

    @Test
    void getGainById() {
    }

    @Test
    void saveGain() {
    }

    @Test
    void updateGainTicketRestant() {
    }

    @Test
    void getAllGain() {
    }

    @Test
    void getAllGainDispo() {
    }
}