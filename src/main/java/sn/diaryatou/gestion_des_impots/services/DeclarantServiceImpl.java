package sn.diaryatou.gestion_des_impots.services;

import org.springframework.stereotype.Service;
import sn.diaryatou.gestion_des_impots.dto.Mapper;
import sn.diaryatou.gestion_des_impots.dto.request.DeclarantRequest;
import sn.diaryatou.gestion_des_impots.entities.Declarant;
import sn.diaryatou.gestion_des_impots.repo.DeclarantRepository;

import java.util.List;
@Service
public class DeclarantServiceImpl implements DeclarantService {
    private final DeclarantRepository repo;
    private final Mapper mapper;
    public DeclarantServiceImpl(DeclarantRepository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<Declarant> list() {
        return repo.findAll();
    }

    @Override
    public Declarant save(DeclarantRequest request) {
        Declarant declarant = mapper.declarantRequestEnDeclarant(request);
        return repo.save(declarant);
    }

    @Override
    public Declarant find(Long id) {
        return repo.findById(id).orElse(null);
    }
}
