package com.example.BackendChallengeItau.controllers;

import com.example.BackendChallengeItau.entities.Estatistica;
import com.example.BackendChallengeItau.services.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping(value = "/estatistica")
    ResponseEntity<Estatistica> getEstatistica() {
        Estatistica estatistica = estatisticaService.getEstatistica();
        return ResponseEntity.ok(estatistica);
    }
}
