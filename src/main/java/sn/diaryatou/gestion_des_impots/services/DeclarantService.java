package sn.diaryatou.gestion_des_impots.services;

import sn.diaryatou.gestion_des_impots.dto.request.DeclarantRequest;
import sn.diaryatou.gestion_des_impots.entities.Declarant;

import java.util.List;

public interface DeclarantService {
    List<Declarant> list();
    Declarant save(DeclarantRequest request);
    Declarant find(Long id);
}
