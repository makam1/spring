package com.sa.filrouge.repository;


import com.sa.filrouge.modele.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
    Optional<Depot> findByNumerocompte(String numerocompte);

}
