package org.project.boulangerie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.project.boulangerie.repository.UtilisateurRepository;
import org.project.boulangerie.service.Utilisateur;
import org.project.boulangerie.service.UtilisateurService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class UtilisateurTest {

    @MockitoBean
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;



    @Test
    public void testGetUserByEmail() {
        Utilisateur utilisateurSimule = new Utilisateur();
        utilisateurSimule.setId(1);
        utilisateurSimule.setEmail("alice@gmail.com");

        Mockito.when(utilisateurRepository.findByEmail("alice@gmail.com")).thenReturn(utilisateurSimule);




    }
}
