package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Magasin")
@Table(
        name = "magasin"
)
public class Magasin {

    @Id
    @SequenceGenerator(
            name = "magasin_sequence",
            sequenceName = "magasin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "magasin_sequence")
    @Column(
            name = "id_magasin",
            updatable = false
    )
    private Long idMagasin;

    @Column(
            name = "nom_magasin",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nomMagasin;

    @Column(
            name = "adresse",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String adresse;

    @Column(
            name = "code_postal",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String code_postal;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "id_magasin")
    private List<Ticket> ticketList = new ArrayList<>();


    public Magasin() {
    }

    public Magasin(Long idMagasin, String nomMagasin, String adresse, String code_postal, List<Ticket> ticketList) {
        this.idMagasin = idMagasin;
        this.nomMagasin = nomMagasin;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ticketList = ticketList;
    }

    public Magasin(String nomMagasin, String adresse, String code_postal) {
        this.nomMagasin = nomMagasin;
        this.adresse = adresse;
        this.code_postal = code_postal;
    }


    public Long getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(Long idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getNomMagasin() {
        return nomMagasin;
    }

    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
