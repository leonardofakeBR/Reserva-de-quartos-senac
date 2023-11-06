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

public class ModComida {
    private int id;
    private Boolean simnao;
    private LocalDateTime datahora;
    private Double preco;

    public ModComida(int id, Boolean simnao, LocalDateTime datahora, Double preco) {
        this.id = id;
        this.simnao = simnao;
        this.datahora = datahora;
        this.preco = preco;
    }

    public ModComida() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getSimnao() {
        return simnao;
    }

    public void setSimnao(Boolean simnao) {
        this.simnao = simnao;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ModComida{" + "id=" + id + ", simnao=" + simnao + ", datahora=" + datahora + ", preco=" + preco + '}';
    }
}
