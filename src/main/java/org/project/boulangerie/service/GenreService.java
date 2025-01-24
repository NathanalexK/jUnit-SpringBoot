package org.project.boulangerie.service;

import org.project.boulangerie.model.Genre;
import org.project.boulangerie.repository.GenreRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxService;

@Service
public class GenreService extends NxService<Genre, Integer> {

	private final GenreRepository genreRepository;

	public GenreService(GenreRepository repository) {
		super(repository);
		this.genreRepository = repository;
	}

}