package org.project.boulangerie.service;

import org.project.boulangerie.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur getUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }
}


