package sn.diaryatou.gestion_des_impots.services;

import sn.diaryatou.gestion_des_impots.dto.request.DeclarationRequest;
import sn.diaryatou.gestion_des_impots.dto.response.DeclarationResponse;
import sn.diaryatou.gestion_des_impots.entities.Declaration;

import java.util.List;

public interface DeclarationService {
    List<DeclarationResponse> list();
    DeclarationResponse save(DeclarationRequest request);
    List<DeclarationResponse> listByDeclarant(Long id);
    Declaration find(Long id);
    DeclarationResponse findById(Long id);
}
