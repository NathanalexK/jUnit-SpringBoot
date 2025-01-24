package org.project.boulangerie.repository;

import org.project.boulangerie.dto.CommissionGenreDTO;
import org.project.boulangerie.model.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Vendeur, Integer> {

    @Query("""
        SELECT new org.project.boulangerie.dto.CommissionGenreDTO(v.vendeur.genre.nom, sum(v.commission)) 
        FROM Vente v  
        WHERE
            (coalesce(:dateMin, null ) is NULL OR v.dateHeure >= :dateMin) AND
            (coalesce(:dateMax, null) is NULL OR v.dateHeure <= :dateMax)
        GROUP BY v.vendeur.genre.nom
    """)
    public List<CommissionGenreDTO> getCommissions(@Param("dateMin")LocalDate dateMin, @Param("dateMax") LocalDate dateMax);
}
