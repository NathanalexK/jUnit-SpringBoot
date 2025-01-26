package org.project.boulangerie.repository;

import org.project.boulangerie.service.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface UtilisateurRepository extends NxRepository<Utilisateur, Integer> {
    @Query("select u from Utilisateur u where u.email = ?1")
    Utilisateur findByEmail(String email);
}
