package sn.diaryatou.gestion_des_impots.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.diaryatou.gestion_des_impots.dto.request.DeclarationRequest;
import sn.diaryatou.gestion_des_impots.dto.response.DeclarationResponse;
import sn.diaryatou.gestion_des_impots.services.DeclarationService;

import java.util.List;

@RestController
@RequestMapping("/declaration")
public class DeclarationController {
    private final DeclarationService service;

    public DeclarationController(DeclarationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DeclarationResponse>> liste(){
        return ResponseEntity.ok(service.list());
    }
    @GetMapping("/declarant/{id}")
    public ResponseEntity<List<DeclarationResponse>> listeByDeclarant(@PathVariable final Long id){
        return ResponseEntity.ok(service.listByDeclarant(id));
    }
    @PostMapping
    public ResponseEntity<DeclarationResponse> save(@RequestBody @Valid DeclarationRequest request){
        return ResponseEntity.ok(service.save(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DeclarationResponse> save(@PathVariable final Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
