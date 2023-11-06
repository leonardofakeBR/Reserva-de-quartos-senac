/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author leonardo.35903
 */
public class ModCliente {
    private int id;
    private int id_pessoa;

    public ModCliente(int id, int id_pessoa) {
        this.id = id;
        this.id_pessoa = id_pessoa;
    }

    public ModCliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    @Override
    public String toString() {
        return "ModPais{" + "id=" + id + ", id_pessoa=" + id_pessoa + '}';
    }
}
