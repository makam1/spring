package com.sa.filrouge.repository;



import com.sa.filrouge.modele.Role;
import com.sa.filrouge.modele.RoleName;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
