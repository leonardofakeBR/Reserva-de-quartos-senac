/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author leonardo.35903
 */

public class ModQuarto {
    private int id;
    private String numero_quarto;
    private String tipo_quarto;
    private int capacidade;
    private Double preco_noite;
    private Boolean disponibilidade;
    private int idHotel;

    public ModQuarto(int id, String numero_quarto, String tipo_quarto, int capacidade, Double preco_noite, Boolean disponibilidade, int idHotel) {
        this.id = id;
        this.numero_quarto = numero_quarto;
        this.tipo_quarto = tipo_quarto;
        this.capacidade = capacidade;
        this.preco_noite = preco_noite;
        this.disponibilidade = disponibilidade;
        this.idHotel = idHotel;
    }

    public ModQuarto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_quarto() {
        return numero_quarto;
    }

    public void setNumero_quarto(String numero_quarto) {
        this.numero_quarto = numero_quarto;
    }

    public String getTipo_quarto() {
        return tipo_quarto;
    }

    public void setTipo_quarto(String tipo_quarto) {
        this.tipo_quarto = tipo_quarto;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Double getPreco_noite() {
        return preco_noite;
    }

    public void setPreco_noite(Double preco_noite) {
        this.preco_noite = preco_noite;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public String toString() {
        return "ModQuarto{" +
               "id=" + id +
               ", numero_quarto=" + numero_quarto +
               ", tipo_quarto=" + tipo_quarto +
               ", capacidade=" + capacidade +
               ", preco_noite=" + preco_noite +
               ", disponibilidade=" + disponibilidade +
               ", idHotel=" + idHotel +
               '}';
    }
}

