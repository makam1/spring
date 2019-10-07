package com.sa.filrouge.repository;


import com.sa.filrouge.modele.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    Optional<Partenaire> findByRaisonsociale(String raisonsociale);
}
