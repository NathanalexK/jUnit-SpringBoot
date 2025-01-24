package org.project.boulangerie.repository;

import org.project.boulangerie.model.Genre;
import org.springframework.stereotype.Repository;
import spring.nx.NxRepository;

@Repository
public interface GenreRepository extends NxRepository<Genre, Integer> {

}