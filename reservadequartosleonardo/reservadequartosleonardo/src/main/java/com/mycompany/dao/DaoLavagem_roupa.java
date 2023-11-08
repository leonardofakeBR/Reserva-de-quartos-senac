/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;
import java.time.LocalDateTime;

/**
 *
 * @author leonardo.35903
 */
public class DaoLavagem_roupa extends BancoDeDadosMySql{
    private String sql; 
    
    public Boolean inserir(int id, Boolean simnao, LocalDateTime data_hora, Double preco) {
        try {
            sql = "INSERT INTO LAVAGEM_ROUPA (ID, SIMNAO, DATA_HORA, PRECO) VALUES (?, ?, ?, ?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);
            getStatement().setBoolean(2, simnao);
            getStatement().setObject(3, data_hora);
            getStatement().setDouble(4, preco);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar(int id, Boolean novoSimnao, LocalDateTime novaDataHora, Double novoPreco) {
        try {
            sql = "UPDATE LAVAGEM_ROUPA SET SIMNAO = ?, DATA_HORA = ?, PRECO = ? WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setBoolean(1, novoSimnao);
            getStatement().setObject(2, novaDataHora);
            getStatement().setDouble(3, novoPreco);
            getStatement().setInt(4, id);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean excluir(int id) {
        try {
            sql = "DELETE FROM LAVAGEM_ROUPA WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ResultSet listarTodos() {
        try {
            sql = "SELECT ID, SIMNAO, DATA_HORA, PRECO FROM LAVAGEM_ROUPA";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT ID, SIMNAO, DATA_HORA, PRECO FROM LAVAGEM_ROUPA WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorSimnao(Boolean simnao) {
        try {
            sql = "SELECT ID, SIMNAO, DATA_HORA, PRECO FROM LAVAGEM_ROUPA WHERE SIMNAO = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setBoolean(1, simnao);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorDataHora(LocalDateTime dataHora) {
        try {
            sql = "SELECT ID, SIMNAO, DATA_HORA, PRECO FROM LAVAGEM_ROUPA WHERE DATA_HORA = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setObject(1, dataHora);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorPreco(Double preco) {
        try {
            sql = "SELECT ID, SIMNAO, DATA_HORA, PRECO FROM LAVAGEM_ROUPA WHERE PRECO = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setDouble(1, preco);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public int buscarProximoId() {
        int id = -1;

        try {
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM LAVAGEM_ROUPA";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());

            getResultado().next(); // Move para o primeiro registro.

            id = getResultado().getInt(1); // Pega o valor retornado na consulta
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id;
    }
}
