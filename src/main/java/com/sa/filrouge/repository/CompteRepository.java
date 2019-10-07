package com.sa.filrouge.repository;


import com.sa.filrouge.modele.Compte;
import com.sa.filrouge.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Compte findByNumerocompte(String numerocompte);

    @Query("SELECT d FROM Compte d WHERE d.numerocompte = :num")
    Compte compte(@Param("num") String num);

}
