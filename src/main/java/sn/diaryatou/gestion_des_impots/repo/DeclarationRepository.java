package sn.diaryatou.gestion_des_impots.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.diaryatou.gestion_des_impots.entities.Declaration;

import java.util.List;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
    List<Declaration> findAllByDeclarant_Id(Long id);
}