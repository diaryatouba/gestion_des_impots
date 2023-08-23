package sn.diaryatou.gestion_des_impots.services;

import org.springframework.stereotype.Service;
import sn.diaryatou.gestion_des_impots.dto.Mapper;
import sn.diaryatou.gestion_des_impots.dto.request.PaiementRequest;
import sn.diaryatou.gestion_des_impots.dto.response.PaiementResponse;
import sn.diaryatou.gestion_des_impots.entities.Declaration;
import sn.diaryatou.gestion_des_impots.entities.Paiement;
import sn.diaryatou.gestion_des_impots.repo.PaiementRepository;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {
    private final PaiementRepository repo;
    private final Mapper mapper;

    public PaiementServiceImpl(PaiementRepository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<PaiementResponse> list() {
        return mapper.paiementsEnPaiementResponses(repo.findAll());
    }

    @Override
    public PaiementResponse payer(PaiementRequest request) {
        Paiement paiement = mapper.paiementRequestEnPaiement(request);

        return mapper.paiementEnPaiementResponse(repo.save(paiement));
    }

    @Override
    public List<PaiementResponse> listByDeclaration(Long id) {
        return mapper.paiementsEnPaiementResponses(repo.findPaiementsByDeclaration_Id(id));
    }

    @Override
    public Paiement find(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PaiementResponse findById(Long id) {
        return mapper.paiementEnPaiementResponse(find(id));
    }
}
