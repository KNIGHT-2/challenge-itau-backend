package com.example.BackendChallengeItau.services;

import com.example.BackendChallengeItau.entities.Estatistica;
import com.example.BackendChallengeItau.entities.Transacao;
import com.example.BackendChallengeItau.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstatisticaService {

@Autowired
private TransacaoRepository transacaoRepository;

    public Estatistica getEstatistica(){

        LocalDateTime dateTime = LocalDateTime.now();

        List<Transacao> transacoes1Minuto = transacaoRepository.getTransacoes().stream()
                .filter(t -> t.getDataHora().plusMinutes(1).isAfter(dateTime)).toList();

        int count = transacoes1Minuto.size();

        double sum = 0.0;
        for (Transacao t : transacoes1Minuto) {
            sum += t.getValor();
        }

        double media = sum/count;

        double min = 0.0;
        double v1, v2 = 0.0;

        for (int i = 0; i < transacoes1Minuto.size(); i++) {
            v1 = transacoes1Minuto.get(i).getValor();
            if (v1<=v2){
                min = v1;
            }
            v2 = v1;
        }

        double max = 0.0;
        v1 = 0.0;
        v2 = 0.0;
        for (int i = 0; i < transacoes1Minuto.size(); i++) {
            v1 = transacoes1Minuto.get(i).getValor();
            if (v1>=v2){
                max = v1;
            }
            v2 = v1;
        }
        Estatistica estatistica = new Estatistica(count, sum, media, min, max);

        return estatistica;
    }
}
