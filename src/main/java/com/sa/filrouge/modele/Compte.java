package com.sa.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode()
public class Compte {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(length = 15)
    private String numerocompte;


    private Long solde;


    @OneToMany(cascade = CascadeType.ALL,mappedBy ="compte")
    @JsonIgnoreProperties("compte")
    private List<Depot> depots;

    @JoinColumn(name = "partenaire",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("comptes")
    private Partenaire partenaire;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="compte")
    @JsonIgnoreProperties("compte")
    private List<Utilisateur> utilisateurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(String numerocompte) {
        this.numerocompte = numerocompte;
    }

    public Long getSolde() {
        return solde;
    }

    public void setSolde(Long solde) {
        this.solde = solde;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

}
