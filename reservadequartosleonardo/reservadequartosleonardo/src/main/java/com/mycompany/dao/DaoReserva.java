/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author leonardo.35903
 */

public class DaoReserva extends BancoDeDadosMySql {
    private String sql;

    public Boolean inserir(int id, int idCliente, int idQuarto, LocalDate checkIn, LocalDate checkOut, String status, int idLavagemRoupa, int idComida, int idPagamento, Double preco) {
        try {
            sql = "INSERT INTO RESERVA (ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);
            getStatement().setInt(2, idCliente);
            getStatement().setInt(3, idQuarto);
            getStatement().setObject(4, checkIn);
            getStatement().setObject(5, checkOut);
            getStatement().setString(6, status);
            getStatement().setInt(7, idLavagemRoupa);
            getStatement().setInt(8, idComida);
            getStatement().setInt(9, idPagamento);
            getStatement().setDouble(10, preco);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar(int id, int idCliente, int idQuarto, LocalDate checkIn, LocalDate checkOut, String status, int idLavagemRoupa, int idComida, int idPagamento, Double preco) {
        try {
            sql = "UPDATE RESERVA SET ID_CLIENTE = ?, ID_QUARTO = ?, CHECK_IN = ?, CHECK_OUT = ?, STATUS = ?, ID_LAVAGEM_ROUPA = ?, ID_COMIDA = ?, ID_PAGAMENTO = ?, PRECO = ? WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idCliente);
            getStatement().setInt(2, idQuarto);
            getStatement().setObject(3, checkIn);
            getStatement().setObject(4, checkOut);
            getStatement().setString(5, status);
            getStatement().setInt(6, idLavagemRoupa);
            getStatement().setInt(7, idComida);
            getStatement().setInt(8, idPagamento);
            getStatement().setDouble(9, preco);
            getStatement().setInt(10, id);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean excluir(int id) {
        try {
            sql = "DELETE FROM RESERVA WHERE ID = ?";

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
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorCliente(int idCliente) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE ID_CLIENTE = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idCliente);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorQuarto(int idQuarto) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE ID_QUARTO = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idQuarto);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorStatus(String status) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE STATUS LIKE ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, status);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorCheckIn(LocalDate checkIn) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE CHECK_IN = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setObject(1, checkIn);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorCheckOut(LocalDate checkOut) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE CHECK_OUT = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setObject(1, checkOut);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorLavagemRoupa(int idLavagemRoupa) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE ID_LAVAGEM_ROUPA = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idLavagemRoupa);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorComida(int idComida) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE ID_COMIDA = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idComida);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorPagamento(int idPagamento) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE ID_PAGAMENTO = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idPagamento);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorPreco(Double preco) {
        try {
            sql = "SELECT ID, ID_CLIENTE, ID_QUARTO, CHECK_IN, CHECK_OUT, STATUS, ID_LAVAGEM_ROUPA, ID_COMIDA, ID_PAGAMENTO, PRECO FROM RESERVA WHERE PRECO = ?";

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
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM RESERVA";

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
