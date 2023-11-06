package com.mycompany.modelo;

import java.time.LocalDateTime;

public class ModAtendimento_quarto {
    private int id;
    private int idReserva;
    private String descricao;
    private LocalDateTime datahora;

    public ModAtendimento_quarto(int id, int idReserva, String descricao, LocalDateTime datahora) {
        this.id = id;
        this.idReserva = idReserva;
        this.descricao = descricao;
        this.datahora = datahora;
    }

    public ModAtendimento_quarto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    @Override
    public String toString() {
        return "ModAtendimento_quarto{" +
               "id=" + id +
               ", idReserva=" + idReserva +
               ", descricao=" + descricao +
               ", datahora=" + datahora +
               '}';
    }
}
