package com.dsp5.tip_top_backend.employe;

import com.dsp5.tip_top_backend.model.*;
import com.dsp5.tip_top_backend.repository.EmployeRepo;
import com.dsp5.tip_top_backend.repository.MagasinRepo;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.repository.UtilisateurRepo;
import com.dsp5.tip_top_backend.service.EmployeService;
import com.dsp5.tip_top_backend.service.service_impl.EmployeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class EmployeServiceImplTest {
    @Mock private EmployeRepo employeRepo;
    private EmployeServiceImpl employeService;

    @BeforeEach
    void setUp(){
        employeService = new EmployeServiceImpl(employeRepo);
    }

    @Test
    void getEmployeById() {
    }

    @Test
    void saveEmploye() {
    }

    @Test
    void updateEmployeMagasin() {
    }

    @Test
    void getAllEmploye() {
        //when
        employeService.getAllEmploye();
        //then
        verify(employeRepo).findAll();
    }
}