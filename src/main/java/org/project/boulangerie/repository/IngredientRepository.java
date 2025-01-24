package org.project.boulangerie.repository;

import org.project.boulangerie.model.Ingredient;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface IngredientRepository extends NxRepository<Ingredient, Integer> {
}
