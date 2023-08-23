package sn.diaryatou.gestion_des_impots.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.diaryatou.gestion_des_impots.entities.Declarant;


@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long> {

}