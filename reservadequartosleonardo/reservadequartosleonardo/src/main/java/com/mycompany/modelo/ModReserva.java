/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author leonardo.35903
 */

import java.time.LocalDate;

public class ModReserva {
    private int id;
    private int idCliente;
    private int idQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String status;
    private int idLavagemRoupa;
    private int idComida;
    private int idPagamento;
    private Double preco;

    public ModReserva(int id, int idCliente, int idQuarto, LocalDate checkIn, LocalDate checkOut, String status, int idLavagemRoupa, int idComida, int idPagamento, Double preco) {
        this.id = id;
        this.idCliente = idCliente;
        this.idQuarto = idQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.idLavagemRoupa = idLavagemRoupa;
        this.idComida = idComida;
        this.idPagamento = idPagamento;
        this.preco = preco;
    }

    public ModReserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdLavagemRoupa() {
        return idLavagemRoupa;
    }

    public void setIdLavagemRoupa(int idLavagemRoupa) {
        this.idLavagemRoupa = idLavagemRoupa;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ModReserva{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idQuarto=" + idQuarto +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", status=" + status +
                ", idLavagemRoupa=" + idLavagemRoupa +
                ", idComida=" + idComida +
                ", idPagamento=" + idPagamento +
                ", preco=" + preco +
                '}';
    }
}
