package sn.diaryatou.gestion_des_impots.dto;

import org.springframework.stereotype.Component;
import sn.diaryatou.gestion_des_impots.dto.request.DeclarantRequest;
import sn.diaryatou.gestion_des_impots.dto.request.DeclarationRequest;
import sn.diaryatou.gestion_des_impots.dto.request.PaiementRequest;
import sn.diaryatou.gestion_des_impots.dto.response.DeclarationResponse;
import sn.diaryatou.gestion_des_impots.dto.response.PaiementResponse;
import sn.diaryatou.gestion_des_impots.entities.Declarant;
import sn.diaryatou.gestion_des_impots.entities.Declaration;
import sn.diaryatou.gestion_des_impots.entities.Paiement;
import sn.diaryatou.gestion_des_impots.repo.DeclarantRepository;
import sn.diaryatou.gestion_des_impots.repo.DeclarationRepository;
import sn.diaryatou.gestion_des_impots.repo.PaiementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public  final class Mapper {
    private final DeclarantRepository declarantRepository;
    private final DeclarationRepository declarationRepository;
    private final PaiementRepository paiementRepository;

    public Mapper(DeclarantRepository declarantRepository, DeclarationRepository declarationRepository, PaiementRepository paiementRepository) {
        this.declarantRepository = declarantRepository;
        this.declarationRepository = declarationRepository;
        this.paiementRepository = paiementRepository;
    }
    public Declarant declarantRequestEnDeclarant(DeclarantRequest request){
        Declarant declarant = new Declarant();
        declarant.setAdresse(request.getAdresse());
        declarant.setEmail(request.getEmail());
        declarant.setTelephone(request.getTelephone());
        declarant.setRaisonSocial(request.getRaisonSocial());
        return declarant;
    }
    public Declaration declarationRequestEnDeclaration(DeclarationRequest request){
        Declaration declaration = new Declaration();
        declaration.setDeclarant(declarantRepository.findById(request.getIdDeclarant()).orElse(null));
        declaration.setDateDeclaration(request.getDateDeclaration());
        declaration.setMontantDeclaration(request.getMontantDeclaration());
        return declaration;
    }
    public Paiement paiementRequestEnPaiement(PaiementRequest request){
        Paiement paiement = new Paiement();
        paiement.setDatePaiement(request.getDatePaiement());
        paiement.setMontantPaiement(request.getMontantPaiement());
        paiement.setDeclaration(declarationRepository.findById(request.getDeclarationId()).orElse(null));
        return paiement;
    }
    public PaiementResponse paiementEnPaiementResponse(Paiement paiement){
        PaiementResponse paiementResponse = new PaiementResponse();
        paiementResponse.setDatePaiement(paiement.getDatePaiement());
        paiementResponse.setId(paiement.getId());
        paiementResponse.setMontantPaiement(paiement.getMontantPaiement());
        paiementResponse.setDeclarationId(paiement.getDeclaration().getId());
        paiementResponse.setRaisonSocialDeclarant(paiement.getDeclaration().getDeclarant().getRaisonSocial());
        return paiementResponse;
    }
    public List<PaiementResponse> paiementsEnPaiementResponses(List<Paiement> paiements){
        List<PaiementResponse> paiementResponses = new ArrayList<>();
        paiements.forEach(paiement->{
            paiementResponses.add(paiementEnPaiementResponse(paiement));
        });
        return paiementResponses;
    }
    public DeclarationResponse declarationEnDeclarationResponse(Declaration declaration){
        DeclarationResponse declarationResponse = new DeclarationResponse();
        declarationResponse.setDeclarantId(declaration.getDeclarant().getId());
        declarationResponse.setRaisonSocial(declaration.getDeclarant().getRaisonSocial());
        declarationResponse.setMontantDeclaration(declaration.getMontantDeclaration());
        AtomicReference<Double> paiements = new AtomicReference<>(0d);
        declaration.getPaiements().forEach(x->{
            paiements.updateAndGet(v -> v + x.getMontantPaiement());
        });
        declarationResponse.setPaiementEffectue(paiements.get());
        declarationResponse.setId(declaration.getId());
        declarationResponse.setDateDeclaration(declaration.getDateDeclaration());
        return declarationResponse;
    }
    public List<DeclarationResponse> declarationsEnDeclarationResponse(List<Declaration> declarations){
        List<DeclarationResponse> responses = new ArrayList<>();
        declarations.forEach(declaration -> {
            responses.add(declarationEnDeclarationResponse(declaration));
        });
        return responses;
    }
}
