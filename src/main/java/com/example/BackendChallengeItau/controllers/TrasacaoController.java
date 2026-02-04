package com.example.BackendChallengeItau.controllers;

import com.example.BackendChallengeItau.entities.Transacao;
import com.example.BackendChallengeItau.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrasacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping(value = "/transacao")
    ResponseEntity<Transacao> newTransacao(@RequestBody Transacao transacao) {
        try {
        String result = transacaoService.newTransacao(transacao);

            switch (result){
                case "Bad request":
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                default:
                    return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @DeleteMapping(value = "/transacao")
    ResponseEntity<Transacao> deleteTransacoes() {
        transacaoService.deleteTransacoes();
        return ResponseEntity.ok().build();
    }
}
