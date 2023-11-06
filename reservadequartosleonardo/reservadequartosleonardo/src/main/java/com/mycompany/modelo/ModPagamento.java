/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author leonardo.35903
 */

import java.time.LocalDateTime;

public class ModPagamento {
    private int id;
    private String tipo;
    private LocalDateTime datahora;

    public ModPagamento(int id, String tipo, LocalDateTime datahora) {
        this.id = id;
        this.tipo = tipo;
        this.datahora = datahora;
    }

    public ModPagamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    @Override
    public String toString() {
        return "ModPagamento{" +
               "id=" + id +
               ", tipo=" + tipo +
               ", datahora=" + datahora +
               '}';
    }
}
