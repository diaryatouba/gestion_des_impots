package sn.diaryatou.gestion_des_impots.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.diaryatou.gestion_des_impots.dto.request.PaiementRequest;
import sn.diaryatou.gestion_des_impots.dto.response.PaiementResponse;
import sn.diaryatou.gestion_des_impots.services.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    private final PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PaiementResponse>> liste(){
        return ResponseEntity.ok(service.list());
    }
    @PostMapping
    public ResponseEntity<PaiementResponse> save(@RequestBody @Valid final PaiementRequest request){
        return ResponseEntity.ok(service.payer(request));
    }
    @GetMapping("/declaration/{id}")
    public ResponseEntity<List<PaiementResponse>> listeByDeclaration(@PathVariable final Long id){
        return ResponseEntity.ok(service.listByDeclaration(id));
    }
    @GetMapping("{id}")
    public ResponseEntity<PaiementResponse> findById(@PathVariable final Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
