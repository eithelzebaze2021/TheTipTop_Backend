package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    @Query(name = "Client.findByIdUser", value = "select * from Client c where c.fk_user_id=:idUser", nativeQuery = true)
    Optional<Client> findByIdUser(@Param("idUser")Long idUser);
}
