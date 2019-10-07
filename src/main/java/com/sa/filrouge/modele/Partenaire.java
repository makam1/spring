package com.sa.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"utilisateurs","comptes","clients","commissions"})
public class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String raisonsociale;

    @Column(length = 10)
    private String ninea;

    @Column(length = 100)
    private String adresse;


    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partenaire")
    @JsonIgnoreProperties({"partenaire","roles","operations"})
    @JsonIgnore
    private List<Utilisateur> utilisateurs;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partenaire")
    @JsonIgnoreProperties({"partenaire","utilisateurs","depots"})
    private List<Compte> comptes;


    @Column(length = 100)
    private String statut;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partanaire")
    @JsonIgnoreProperties("partanaire")
    @JsonIgnore
    private List<Client> clients;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="utilisateur")
    @JsonIgnoreProperties("utilisateur")
    @JsonIgnore
    private List<Commission> commissions;

    public Partenaire(){}

    public Partenaire (String raisonsociale, String ninea, String adresse) {
        this.raisonsociale = raisonsociale;
        this.ninea = ninea;
        this.adresse= adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Commission> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<Commission> commissions) {
        this.commissions = commissions;
    }
}
