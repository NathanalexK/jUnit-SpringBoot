package org.project.boulangerie.api;

import org.project.boulangerie.dto.RecetteDTO;
import org.project.boulangerie.model.ProduitFini;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
@CrossOrigin("*")
public class RecetteApiController {
//    public Li getRecette()

    @GetMapping("/{id}")
    public ResponseEntity<List<RecetteDTO>> getRecettes(@PathVariable("id") ProduitFini pf) {
        return ResponseEntity.ok(pf.getRecettesDTO());
    }

}
