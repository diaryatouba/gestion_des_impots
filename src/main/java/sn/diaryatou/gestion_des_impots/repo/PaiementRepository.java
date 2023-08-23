package sn.diaryatou.gestion_des_impots.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.diaryatou.gestion_des_impots.entities.Paiement;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement>findPaiementsByDeclaration_Id(Long id);


}