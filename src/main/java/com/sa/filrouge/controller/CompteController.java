package com.sa.filrouge.controller;

import com.sa.filrouge.modele.*;
import com.sa.filrouge.repository.CompteRepository;
import com.sa.filrouge.repository.DepotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private DepotRepository depotRepository;


    @PostMapping(value = "/compte/new",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String add(@RequestBody(required = false)Compte compte) {

        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        compte.setNumerocompte(format.format(date));
        compte.setPartenaire(compte.getPartenaire());
        compte.setSolde(5000L);
        compteRepository.save(compte);

        String message="Compte ajouté avec succés";
        return message;
    }


    @PostMapping(value = "/depot/new",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String depot(@RequestBody(required = false)Depot depot) {

        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        depot.setDate(new Date());


        Compte compte = compteRepository.findByNumerocompte(depot.getNumerocompte());


        depot.setCompte(compte);
        depot.setMontant(depot.getMontant());
        depot.setNumerocompte(depot.getNumerocompte());

        compte.setSolde(compte.getSolde()+depot.getMontant());

        compteRepository.save(compte);

        depotRepository.save(depot);

        String message="Dépôt effectué avec succés";
        return message;
    }

    @PostMapping(value = "/findcompte",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte findCompte(@RequestBody(required = false)Depot depot) {

        String num= depot.getNumerocompte();


        Compte compte = compteRepository.findByNumerocompte(num);

        return compte;
    }
    
}
