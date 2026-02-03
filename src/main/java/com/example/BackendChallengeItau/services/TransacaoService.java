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
            if (transacaoRepository.getTransacoes().contains(transacao)){
                System.out.println("Transação criada com sucesso.");
                return "Created";
            }
        }
        return "Bad request";
    }

    public void deleteTransacoes() {
        transacaoRepository.getTransacoes().clear();
        if(transacaoRepository.getTransacoes().isEmpty()){
            System.out.println("Transações limpas.");
        }
    }

}
