package com.example.BackendChallengeItau.entities;

import java.time.LocalDateTime;

public class Transacao {

    private Double valor;
    private LocalDateTime dataHora;

    public Transacao(Double valor, String dataHora) {
        this.valor = valor;
        this.dataHora = LocalDateTime.parse(dataHora);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = LocalDateTime.parse(dataHora);
    }
}
