package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query(name = "Role.findAllStrRole", value = "select nom from Role", nativeQuery = true)
    List<String> findAllStrRole();

    @Query(name = "Role.findStrRoleById", value = "select nom from Role r where r.id_role =:idRole", nativeQuery = true)
    String findStrRoleById(@Param("idRole")Integer idRole);

    @Query(name = "Role.findIdRoleByStr", value = "select id_role from Role r where r.nom =:nom", nativeQuery = true)
    Integer findIdRoleByStr(@Param("nom")String nom);

}
