package sn.diaryatou.gestion_des_impots.services;

import org.springframework.stereotype.Service;
import sn.diaryatou.gestion_des_impots.dto.Mapper;
import sn.diaryatou.gestion_des_impots.dto.request.DeclarationRequest;
import sn.diaryatou.gestion_des_impots.dto.response.DeclarationResponse;
import sn.diaryatou.gestion_des_impots.entities.Declaration;
import sn.diaryatou.gestion_des_impots.repo.DeclarationRepository;

import java.util.List;
@Service
public class DeclarationServiceImpl implements DeclarationService {
    private final DeclarationRepository repo;
    private final Mapper mapper;

    public DeclarationServiceImpl(DeclarationRepository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<DeclarationResponse> list() {
        return mapper.declarationsEnDeclarationResponse(repo.findAll());
    }

    @Override
    public DeclarationResponse save(DeclarationRequest request) {
        Declaration declaration = mapper.declarationRequestEnDeclaration(request);
        return mapper.declarationEnDeclarationResponse(repo.save(declaration));
    }

    @Override
    public List<DeclarationResponse> listByDeclarant(Long id) {
        return mapper.declarationsEnDeclarationResponse(repo.findAllByDeclarant_Id(id));
    }

    @Override
    public Declaration find(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public DeclarationResponse findById(Long id) {
        Declaration declaration = find(id);
        return mapper.declarationEnDeclarationResponse(declaration);
    }
}
