package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Gain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GainRepo extends JpaRepository<Gain, Long> {
}
