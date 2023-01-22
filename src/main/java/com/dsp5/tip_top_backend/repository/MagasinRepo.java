package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Employe;
import com.dsp5.tip_top_backend.model.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagasinRepo extends JpaRepository<Magasin, Long> {
}
