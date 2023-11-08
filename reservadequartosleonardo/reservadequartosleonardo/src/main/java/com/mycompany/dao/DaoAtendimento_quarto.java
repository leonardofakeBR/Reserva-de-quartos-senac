/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;

/**
 *
 * @author leonardo.35903
 */

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class DaoAtendimento_quarto extends BancoDeDadosMySql {
    private String sql;

    public Boolean inserir(int id, int idReserva, String descricao, LocalDateTime data_hora) {
        try {
            sql = "INSERT INTO ATENDIMENTO_QUARTO (ID, ID_RESERVA, DESCRICAO, DATA_HORA) VALUES (?, ?, ?, ?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);
            getStatement().setInt(2, idReserva);
            getStatement().setString(3, descricao);
            getStatement().setObject(4, data_hora);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar(int id, int idReserva, String descricao, LocalDateTime data_hora) {
        try {
            sql = "UPDATE ATENDIMENTO_QUARTO SET ID_RESERVA = ?, DESCRICAO = ?, DATA_HORA = ? WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idReserva);
            getStatement().setString(2, descricao);
            getStatement().setObject(3, data_hora);
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
            sql = "DELETE FROM ATENDIMENTO_QUARTO WHERE ID = ?";

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
            sql = "SELECT ID, ID_RESERVA, DESCRICAO, DATA_HORA FROM ATENDIMENTO_QUARTO";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT ID, ID_RESERVA, DESCRICAO, DATA_HORA FROM ATENDIMENTO_QUARTO WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorIdReserva(int idReserva) {
    try {
        sql = "SELECT ID, ID_RESERVA, DESCRICAO, DATA_HORA FROM ATENDIMENTO_QUARTO WHERE ID_RESERVA = ?";

        setStatement(getConexao().prepareStatement(sql));

        getStatement().setInt(1, idReserva);

        setResultado(getStatement().executeQuery());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return getResultado();
}

    public ResultSet listarPorDescricao(String descricao) {
        try {
            sql = "SELECT ID, ID_RESERVA, DESCRICAO, DATA_HORA FROM ATENDIMENTO_QUARTO WHERE DESCRICAO LIKE ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, "%" + descricao + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorDataHora(LocalDateTime data_hora) {
        try {
            sql = "SELECT ID, ID_RESERVA, DESCRICAO, DATA_HORA FROM ATENDIMENTO_QUARTO WHERE DATA_HORA = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setObject(1, data_hora);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public int buscarProximoId() {
        int id = -1;

        try {
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ATENDIMENTO_QUARTO";

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
