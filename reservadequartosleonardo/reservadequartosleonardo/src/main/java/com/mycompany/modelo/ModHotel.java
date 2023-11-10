/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author leonardo.35903
 */
public class ModHotel {
    private int id;
    private int idEndereco;
    private String nome;
    private String descricao;

    public ModHotel(int id, int idEndereco, String nome, String descricao) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.nome = nome;
        this.descricao = descricao;
    }

    public ModHotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "ModEndereco{" + "id=" + id + ", idEndereco=" + idEndereco + ", nome=" + nome + 
                ", descricao=" + descricao + '}';
    }
}
