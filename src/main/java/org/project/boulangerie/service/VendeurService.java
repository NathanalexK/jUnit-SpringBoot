package org.project.boulangerie.service;

import org.project.boulangerie.dto.CommissionGenreDTO;
import org.project.boulangerie.dto.CommissionVendeurDTO;
import org.project.boulangerie.repository.CommissionRepository;
import org.project.boulangerie.model.Vendeur;
import org.project.boulangerie.repository.VendeurRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import spring.nx.NxService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VendeurService extends NxService<Vendeur, Integer> {

	private final VendeurRepository vendeurRepository;
	private final JdbcTemplate jdbcTemplate;
	private final CommissionRepository commissionRepository;

	public VendeurService(VendeurRepository repository, JdbcTemplate jdbcTemplate, CommissionRepository commissionRepository) {
		super(repository);
		this.vendeurRepository = repository;
		this.jdbcTemplate = jdbcTemplate;
		this.commissionRepository = commissionRepository;
	}

	public List<CommissionVendeurDTO> getCommissionsParVendeur(LocalDate debut, LocalDate fin) {
		List<Object> params = new ArrayList<>();
		StringBuilder queryBuilder = new StringBuilder("""
				select
				    v.id as id,
				    v.nom as nom,
				    genre.nom as genre, 
				    total
				from (
				select
				    id_vendeur,
				    sum(coalesce(commission, 0)) as total
				from vente
				where true
				""");

		if (debut != null) {
			queryBuilder.append(" AND date_heure >= ? ");
			params.add(debut);
		}

		if (fin != null) {
			queryBuilder.append(" AND date_heure <= ? ");
			params.add(fin);
		}

		queryBuilder.append("""
				 group by id_vendeur ) as v1
				join vendeur v 
				on v1.id_vendeur = v.id
				join genre
				on v.id_genre = genre.id
				order by total DESC
				""");

		List<Map<String, Object>> list = jdbcTemplate.queryForList(queryBuilder.toString(), params.toArray());
		return list.stream().map(map -> {
			CommissionVendeurDTO dto = new CommissionVendeurDTO();
			dto.setId(Integer.parseInt(String.valueOf(map.get("id"))));
			dto.setNom(String.valueOf(map.get("nom")));
			dto.setTotal(Double.parseDouble(String.valueOf(map.get("total"))));
			dto.setGenre(String.valueOf(map.get("genre")));
			return dto;
		}).toList();
	}


	public List<CommissionGenreDTO> getCommissionsParGenre(LocalDate debut, LocalDate fin) {
		List<CommissionGenreDTO> commissionGenreDTOS = commissionRepository.getCommissions(debut, fin);
		boolean hasMale = false;
		boolean hasFemale = false;

		for(CommissionGenreDTO cg: commissionGenreDTOS) {
			if(cg.getNom().equalsIgnoreCase("homme")) {
				hasMale = true;
			}
			if(cg.getNom().equalsIgnoreCase("femme")) {
				hasFemale = true;
			}
		}

		if(!hasMale) {
			commissionGenreDTOS.add(new CommissionGenreDTO("Homme", 0.0));
		}

		if(!hasFemale) {
			commissionGenreDTOS.add(new CommissionGenreDTO("Femme", 0.0));
		}

		return commissionGenreDTOS;
	}


//	}

}