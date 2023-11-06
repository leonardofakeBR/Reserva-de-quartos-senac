/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author leonardo.35903
 */
public class ModRequisitos_cliente {
    private int id;
    private int idCliente;
    private String descricao;

    public ModRequisitos_cliente(int id, int idCliente, String descricao) {
        this.id = id;
        this.idCliente = idCliente;
        this.descricao = descricao;
    }

    public ModRequisitos_cliente() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "ModPais{" + "id=" + id + ", descricao=" + descricao + '}';
    }
}
