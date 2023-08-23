package sn.diaryatou.gestion_des_impots.services;

import sn.diaryatou.gestion_des_impots.dto.request.DeclarationRequest;
import sn.diaryatou.gestion_des_impots.dto.request.PaiementRequest;
import sn.diaryatou.gestion_des_impots.dto.response.DeclarationResponse;
import sn.diaryatou.gestion_des_impots.dto.response.PaiementResponse;
import sn.diaryatou.gestion_des_impots.entities.Declaration;
import sn.diaryatou.gestion_des_impots.entities.Paiement;

import java.util.List;

public interface PaiementService {
    List<PaiementResponse> list();
    PaiementResponse payer(PaiementRequest request);
    List<PaiementResponse> listByDeclaration(Long id);
    Paiement find(Long id);
    PaiementResponse findById(Long id);
}
