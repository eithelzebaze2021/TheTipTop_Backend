package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Long> {

    @Query(name = "Employe.findByIdUser", value = "select * from Employe e where e.fk_user_id=:idU", nativeQuery = true)
    Optional<Employe> findByIdUser(@Param("idU") Long idU);
}
