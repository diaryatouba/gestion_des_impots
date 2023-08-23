package sn.diaryatou.gestion_des_impots.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.diaryatou.gestion_des_impots.dto.request.DeclarantRequest;
import sn.diaryatou.gestion_des_impots.entities.Declarant;
import sn.diaryatou.gestion_des_impots.services.DeclarantService;

import java.util.List;

@RestController
@RequestMapping("/declarant")
public class DeclarantController {
    private final DeclarantService service;

    public DeclarantController(DeclarantService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Declarant>> liste(){
        return ResponseEntity.ok(service.list());
    }
    @PostMapping
    public ResponseEntity<Declarant> save(@RequestBody @Valid final DeclarantRequest request){
        return ResponseEntity.ok(service.save(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Declarant> findById(@PathVariable final  Long id){
        return ResponseEntity.ok(service.find(id));
    }
}
