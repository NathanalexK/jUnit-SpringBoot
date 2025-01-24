package org.project.boulangerie.service;

import jakarta.transaction.Transactional;
import org.project.boulangerie.form.VenteFilleForm;
import org.project.boulangerie.form.VenteForm;
import org.project.boulangerie.model.MvtStock;
import org.project.boulangerie.model.Vente;
import org.project.boulangerie.model.VenteDetail;
import org.project.boulangerie.repository.MvtStockRepository;
import org.project.boulangerie.repository.VenteRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VenteService extends NxService<Vente, Integer> {

    private final VenteRepository venteRepository;
    private final MvtStockRepository mvtStockRepository;
    private final DatabaseService databaseService;

    public VenteService(VenteRepository repository,
                        VenteRepository venteRepository,
                        MvtStockRepository mvtStockRepository, DatabaseService databaseService) {
        super(repository);
        this.venteRepository = venteRepository;
        this.mvtStockRepository = mvtStockRepository;
        this.databaseService = databaseService;
    }

    @Transactional
    public Vente save(VenteForm venteForm) throws Exception {
        Vente vente = new Vente();
        vente.setDateHeure(venteForm.getDateVente());
        vente.setClient(venteForm.getClient());

        Double total = 0.00;

        List<VenteDetail> venteDetailList = new ArrayList<>();
        for(VenteFilleForm fille: venteForm.getVenteFilleForms()) {
            VenteDetail details = new VenteDetail();
            details.setProduitFini(fille.getProduitFini());
            details.setVente(vente);
            details.setQuantite(fille.getQuantite());
            details.setDPrixUnitaire(fille.getProduitFini().getProduit().getPrixVente());
            total += fille.getProduitFini().getProduit().getPrixVente() * details.getQuantite();

            venteDetailList.add(details);
        }

        vente.setVendeur(venteForm.getVendeur());
        Double pourc = databaseService.getCommission();
        Double minCommission = databaseService.getMinCommission();
        if(total >= minCommission) {
            vente.setCommission(total * pourc);
        } else {
            vente.setCommission(0.0);
        }


        vente.setVenteDetailList(venteDetailList);
        vente = venteRepository.save(vente);
        List<MvtStock> mvtStockList = vente.genererSortieStock();

        // TODO : Decommenter
//        mvtStockRepository.saveAll(mvtStockList);

        return vente;
    }

    public List<Vente> getVenteByDate(LocalDate date) {
        if (date == null) return venteRepository.findAll();
        return venteRepository.findByDate(date);
    }


}
