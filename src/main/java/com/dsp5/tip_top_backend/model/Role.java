package com.dsp5.tip_top_backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Role")
@Table(
        name = "role",
        uniqueConstraints = {
                @UniqueConstraint(name = "role_unique", columnNames = "nom")
        }
)
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "role_sequence")
    @Column(
            name = "id_role",
            updatable = false
    )
    private Integer idRole;
    @Column(
            name = "nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "id_role")
    private List<Utilisateur> userList = new ArrayList<>();

    public Role() {
    }

    public Role(Integer idRole, String nom, List<Utilisateur> userList) {
        this.idRole = idRole;
        this.nom = nom;
        this.userList = userList;
    }

    public Role(Integer idRole, String nom) {
        this.idRole = idRole;
        this.nom = nom;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Utilisateur> getUserList() {
        return userList;
    }

    public void setUserList(List<Utilisateur> userList) {
        this.userList = userList;
    }
}
