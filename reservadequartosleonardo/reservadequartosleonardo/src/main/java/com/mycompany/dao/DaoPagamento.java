/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author leonardo.35903
 */
public class DaoPagamento extends BancoDeDadosMySql{
    private String sql; 

    public Boolean inserir(int id, String tipo) {
        try {
            sql = "INSERT INTO PAGAMENTO (ID, TIPO) VALUES (?, ?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);
            getStatement().setString(2, tipo);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar(int id, String novoTipo) {
        try {
            sql = "UPDATE PAGAMENTO SET TIPO = ? WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, novoTipo);
            getStatement().setInt(3, id);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean excluir(int id) {
        try {
            sql = "DELETE FROM PAGAMENTO WHERE ID = ?";

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
            sql = "SELECT ID, TIPO FROM PAGAMENTO";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT ID, TIPO FROM PAGAMENTO WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorTipo(String tipo) {
        try {
            sql = "SELECT ID, TIPO FROM PAGAMENTO WHERE TIPO LIKE ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, tipo + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public int buscarProximoId() {
        int id = -1;

        try {
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PAGAMENTO";

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
