package org.project.boulangerie.service;

import jakarta.transaction.Transactional;
import org.project.boulangerie.form.AchatFilleForm;
import org.project.boulangerie.form.AchatForm;
import org.project.boulangerie.model.Achat;
import org.project.boulangerie.model.AchatDetails;
import org.project.boulangerie.model.MvtStock;
import org.project.boulangerie.repository.AchatRepository;
import org.project.boulangerie.repository.MvtStockRepository;
import org.springframework.stereotype.Service;
import spring.nx.NxRepository;
import spring.nx.NxService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchatService extends NxService<Achat, Integer> {

    private final AchatRepository achatRepository;
    private final MvtStockRepository mvtStockRepository;

    public AchatService(AchatRepository repository,
                        AchatRepository achatRepository,
                        MvtStockRepository mvtStockRepository) {
        super(repository);
        this.achatRepository = achatRepository;
        this.mvtStockRepository = mvtStockRepository;
    }

    @Transactional
    public Achat save(AchatForm achatForm) {
        Achat achat = new Achat();
        achat.setDateHeure(achatForm.getDateAchat());
        achat.setFournisseur(achatForm.getFournisseur());

        List<AchatDetails> list = new ArrayList<>();

        Double total = 0.00;
        for(AchatFilleForm fille: achatForm.getAchatFilleForms()) {
            AchatDetails details = new AchatDetails();
            details.setIngredient(fille.getIngredient());
            details.setAchatMere(achat);
            details.setQuantite(fille.getQuantite());
            details.setDPrixUnitaire(details.getDPrixUnitaire());
            total += details.getDPrixUnitaire() * details.getQuantite();

            list.add(details);
        }


        achat.setAchatDetailsList(list);
        achat.setDPrixTotal(total);
        achat = achatRepository.save(achat);
        List<MvtStock> mvtStockList = achat.genererEntreeStock();
        mvtStockRepository.saveAll(mvtStockList);
        return achat;
    }
}
