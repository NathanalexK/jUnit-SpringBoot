package org.project.boulangerie.repository;

import org.project.boulangerie.model.Recommendation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface RecommendationRepository extends NxRepository<Recommendation, Integer> {

    @Query("select (count(r) > 0) from Recommendation r where r.idProduitFini.id = ?1 and r.mois = ?2 and r.annee = ?3")
    boolean isRecommendationAlreadyExist(Integer id, Integer mois, Integer annee);
}