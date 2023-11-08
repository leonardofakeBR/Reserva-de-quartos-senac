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
public class DaoTransferencia extends BancoDeDadosMySql {
    private String sql;

    public Boolean inserir(int id, int idReserva, LocalDate data, int idQuartoNovo, int idQuartoAntigo) {
        try {
            sql = "INSERT INTO TRANSFERENCIA (ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO) VALUES (?, ?, ?, ?, ?)";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);
            getStatement().setInt(2, idReserva);
            getStatement().setObject(3, data);
            getStatement().setInt(4, idQuartoNovo);
            getStatement().setInt(5, idQuartoAntigo);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar(int id, int idReserva, LocalDate data, int idQuartoNovo, int idQuartoAntigo) {
        try {
            sql = "UPDATE TRANSFERENCIA SET ID_RESERVA = ?, DATA = ?, ID_QUARTO_NOVO = ?, ID_QUARTO_ANTIGO = ? WHERE ID = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, idReserva);
            getStatement().setObject(2, data);
            getStatement().setInt(3, idQuartoNovo);
            getStatement().setInt(4, idQuartoAntigo);
            getStatement().setInt(5, id);

            getStatement().executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean excluir(int id) {
        try {
            sql = "DELETE FROM TRANSFERENCIA WHERE ID = ?";

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
            sql = "SELECT ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO FROM TRANSFERENCIA";

            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO FROM TRANSFERENCIA WHERE ID = ?";

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
        sql = "SELECT ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO FROM TRANSFERENCIA WHERE ID_RESERVA = ?";

        setStatement(getConexao().prepareStatement(sql));

        getStatement().setInt(1, idReserva);

        setResultado(getStatement().executeQuery());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return getResultado();
}

public ResultSet listarPorData(LocalDate data) {
    try {
        sql = "SELECT ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO FROM TRANSFERENCIA WHERE DATA = ?";

        setStatement(getConexao().prepareStatement(sql));

        getStatement().setObject(1, data);

        setResultado(getStatement().executeQuery());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return getResultado();
}

public ResultSet listarPorQuartoNovo(int idQuartoNovo) {
    try {
        sql = "SELECT ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO FROM TRANSFERENCIA WHERE ID_QUARTO_NOVO = ?";

        setStatement(getConexao().prepareStatement(sql));

        getStatement().setInt(1, idQuartoNovo);

        setResultado(getStatement().executeQuery());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return getResultado();
}

public ResultSet listarPorQuartoAntigo(int idQuartoAntigo) {
    try {
        sql = "SELECT ID, ID_RESERVA, DATA, ID_QUARTO_NOVO, ID_QUARTO_ANTIGO FROM TRANSFERENCIA WHERE ID_QUARTO_ANTIGO = ?";

        setStatement(getConexao().prepareStatement(sql));

        getStatement().setInt(1, idQuartoAntigo);

        setResultado(getStatement().executeQuery());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return getResultado();
}

    public int buscarProximoId() {
        int id = -1;

        try {
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM TRANSFERENCIA";

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
