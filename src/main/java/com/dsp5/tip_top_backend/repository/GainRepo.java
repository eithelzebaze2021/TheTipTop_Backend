package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Gain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GainRepo extends JpaRepository<Gain, Long> {

    @Query(name = "Gain.findGainDispo", value = "select * from Gain g where g.nbre_ticket_restant!=0", nativeQuery = true)
    List<Gain> findGainDispo();
}
