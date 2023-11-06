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

public class ModTransferencia {
    private int id;
    private int idReserva;
    private LocalDate data;
    private int idQuartoNovo;
    private int idQuartoAntigo;

    public ModTransferencia(int id, int idReserva, LocalDate data, int idQuartoNovo, int idQuartoAntigo) {
        this.id = id;
        this.idReserva = idReserva;
        this.data = data;
        this.idQuartoNovo = idQuartoNovo;
        this.idQuartoAntigo = idQuartoAntigo;
    }

    public ModTransferencia() {
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getIdQuartoNovo() {
        return idQuartoNovo;
    }

    public void setIdQuartoNovo(int idQuartoNovo) {
        this.idQuartoNovo = idQuartoNovo;
    }

    public int getIdQuartoAntigo() {
        return idQuartoAntigo;
    }

    public void setIdQuartoAntigo(int idQuartoAntigo) {
        this.idQuartoAntigo = idQuartoAntigo;
    }

    @Override
    public String toString() {
        return "ModTransferencia{" +
               "id=" + id +
               ", idReserva=" + idReserva +
               ", data=" + data +
               ", idQuartoNovo=" + idQuartoNovo +
               ", idQuartoAntigo=" + idQuartoAntigo +
               '}';
    }
}
