package com.sa.filrouge.repository;

import com.sa.filrouge.modele.Partenaire;
import com.sa.filrouge.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByPartenaire(Partenaire partenaire);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


}