package com.dsp5.tip_top_backend.admin;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.service.AdminService;
import com.dsp5.tip_top_backend.service.service_impl.AdminServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {
    @Mock private RoleRepo roleRepo;

    private AdminServiceImpl adminService;

    @BeforeEach()
    void setUp(){
        adminService = new AdminServiceImpl(roleRepo);

    }



    @Test
    void getAllRole() {
        //when
        adminService.getAllRole();
        //then
        verify(roleRepo).findAll();
    }

    @Test
    void getAllStrRole() {
        //when
        adminService.getAllStrRole();
        //then
        verify(roleRepo).findAllStrRole();
    }

    @Test
    void saveRole() {
        //given
        Role role = new Role(
                null,
                "ROLE_CLIENT"
        );
      //  role = roleRepo.save(role);


        //when
        adminService.saveRole(role);
        //then
        ArgumentCaptor<Role> roleArgumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(roleRepo).save(roleArgumentCaptor.capture());

        Role capturedRole = roleArgumentCaptor.getValue();
        assertThat(capturedRole).isEqualTo(role);



    }
}