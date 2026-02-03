package com.example.BackendChallengeItau.repositories;

import com.example.BackendChallengeItau.entities.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private List<Transacao> transacoes = new ArrayList<>();

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
