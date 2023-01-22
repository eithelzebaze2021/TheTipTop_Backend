package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Employe")
@Table(
        name = "employe"
)
public class Employe {

    @Id
    @SequenceGenerator(
            name = "employe_sequence",
            sequenceName = "employe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "employe_sequence")
    @Column(
            name = "id_employe",
            updatable = false
    )
    private Long idEmploye;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_magasin_id")
    private Magasin magasin_empl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private Utilisateur user_employe;


    public Employe() {
    }

    public Employe(Long idEmploye, Magasin magasin_empl, Utilisateur user_employe) {
        this.idEmploye = idEmploye;
        this.magasin_empl = magasin_empl;
        this.user_employe = user_employe;
    }

    public Employe(Magasin magasin_empl, Utilisateur user_employe) {
        this.magasin_empl = magasin_empl;
        this.user_employe = user_employe;
    }

    public Long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Magasin getMagasin_empl() {
        return magasin_empl;
    }

    public void setMagasin_empl(Magasin magasin_empl) {
        this.magasin_empl = magasin_empl;
    }

    public Utilisateur getUser_employe() {
        return user_employe;
    }

    public void setUser_employe(Utilisateur user_employe) {
        this.user_employe = user_employe;
    }
}
