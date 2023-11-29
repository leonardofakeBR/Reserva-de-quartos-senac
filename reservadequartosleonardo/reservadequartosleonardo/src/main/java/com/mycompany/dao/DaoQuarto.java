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

public class DaoQuarto extends BancoDeDadosMySql {
    private String sql;

    public Boolean inserir(int id, String numeroQuarto, String tipoQuarto, int capacidade, Double precoNoite, Boolean disponibilidade, int idHotel) {
        try {
            sql = "INSERT INTO QUARTO (ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL) VALUES (?, ?, ?, ?, ?, ?, ?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);
            getStatement().setString(2, numeroQuarto);
            getStatement().setString(3, tipoQuarto);
            getStatement().setInt(4, capacidade);
            getStatement().setDouble(5, precoNoite);
            getStatement().setBoolean(6, disponibilidade);
            getStatement().setInt(7, idHotel);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar(int id, String numeroQuarto, String tipoQuarto, int capacidade, Double precoNoite, Boolean disponibilidade, int idHotel) {
        try {
            sql = "UPDATE QUARTO SET NUMERO_QUARTO = ?, TIPO_QUARTO = ?, CAPACIDADE = ?, PRECO_NOITE = ?, DISPONIBILIDADE = ?, ID_HOTEL = ? WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, numeroQuarto);
            getStatement().setString(2, tipoQuarto);
            getStatement().setInt(3, capacidade);
            getStatement().setDouble(4, precoNoite);
            getStatement().setBoolean(5, disponibilidade);
            getStatement().setInt(6, idHotel);
            getStatement().setInt(7, id);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean excluir(int id) {
        try {
            sql = "DELETE FROM QUARTO WHERE ID = ?";

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
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorNumeroQuarto(String numeroQuarto) {
    try {
        sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE NUMERO_QUARTO = ?";

        setStatement(getConexao().prepareStatement(sql));

        getStatement().setString(1, numeroQuarto);

        setResultado(getStatement().executeQuery());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return getResultado();
}

    public ResultSet listarPorTipoQuarto(String tipoQuarto) {
        try {
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE TIPO_QUARTO = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, tipoQuarto);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorCapacidade(int capacidade) {
        try {
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE CAPACIDADE = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, capacidade);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorPrecoNoite(Double precoNoite) {
        try {
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE PRECO_NOITE = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setDouble(1, precoNoite);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorDisponibilidade(Boolean disponibilidade) {
        try {
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE DISPONIBILIDADE = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setBoolean(1, disponibilidade);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorIdHotel(int idHotel) {
        try {
            sql = "SELECT ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL FROM QUARTO WHERE ID_HOTEL = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idHotel);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet PegarPrecoNoite(int id) {
        try {
            sql = "SELECT PRECO_NOITE FROM QUARTO WHERE id = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setDouble(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public int buscarProximoId() {
        int id = -1;

        try {
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM QUARTO";

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
