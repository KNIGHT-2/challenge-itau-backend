package com.example.BackendChallengeItau.services;

import com.example.BackendChallengeItau.entities.Transacao;
import com.example.BackendChallengeItau.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public String newTransacao(Transacao transacao) {
        if((transacao.getValor() >= 0.0) && (transacao.getDataHora().isBefore(LocalDateTime.now())) ){
            transacaoRepository.getTransacoes().add(transacao);
            return "Created";
        }else{
            return "Bad request";
        }
    }

}
