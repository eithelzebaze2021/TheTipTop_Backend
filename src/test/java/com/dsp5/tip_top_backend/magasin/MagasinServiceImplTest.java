package com.dsp5.tip_top_backend.magasin;

import com.dsp5.tip_top_backend.model.Magasin;
import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.repository.MagasinRepo;
import com.dsp5.tip_top_backend.service.service_impl.EmployeServiceImpl;
import com.dsp5.tip_top_backend.service.service_impl.MagasinServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MagasinServiceImplTest {
    @Mock private MagasinRepo magasinRepo;
    @InjectMocks
    private MagasinServiceImpl magasinService;

    @BeforeEach
    void setUp(){
        magasinService = new MagasinServiceImpl(magasinRepo);
    }

    @Test
    void getMagasinById() {

    }

    @Test
    void saveMagasin() {
        //given
        Magasin magasin = new Magasin(
                "Dsp5Magasin",
                "Vincenne",
                "94",
                "Vincenne"
        );
        //when
        magasinService.saveMagasin(magasin);
        //then
        ArgumentCaptor<Magasin> magasinArgumentCaptor = ArgumentCaptor.forClass(Magasin.class);
        verify(magasinRepo).save(magasinArgumentCaptor.capture());

        Magasin captureMagasin = magasinArgumentCaptor.getValue();
        assertThat(captureMagasin).isEqualTo(magasin);

    }

    @Test
    void updateMagasinInfo() {

    }

    @Test
    void getAllMagasin() {
        //when
        magasinService.getAllMagasin();
        //then
        verify(magasinRepo).findAll();

    }
}