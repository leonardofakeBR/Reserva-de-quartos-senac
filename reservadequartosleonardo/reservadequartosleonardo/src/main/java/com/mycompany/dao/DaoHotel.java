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
public class DaoHotel extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, int idEndereco, String nome, String descricao){
        try{
            sql = "INSERT INTO HOTEL (ID, IDENDERECO, NOME, DESCRICAO) VALUES (?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idEndereco);
            getStatement().setString(3, nome);
            getStatement().setString(4, descricao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int idEndereco, String nome, String descricao){
        try{
            sql = "UPDATE HOTEL SET IDENDERECO = ?, NOME = ?, DESCRICAO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idEndereco);
            getStatement().setString(3, nome);
            getStatement().setString(4,descricao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM HOTEL WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
public ResultSet listarTodos(){
    try{
        sql = 
            "SELECT " +
            "  H.ID AS ID, " +
            "  C.NOME AS CIDADE, " +
            "  E.NOME_RUA AS RUA, " +
            "  E.CEP AS CEP, " +
            "  E.NUMERO_RESIDENCIA AS NUM_RES, " +
            "  H.NOME AS NOME, " +
            "  IFNULL(H.DESCRICAO, '') AS DESCRICAO " +
            "FROM " +
            "  HOTEL H " +
            "JOIN ENDERECO E ON " +
            "  E.ID = H.IDENDERECO " +
            "JOIN CIDADE C ON " +
            "  C.ID = E.ID_CIDADE";

        setStatement(getConexao().prepareStatement(sql));
        setResultado(getStatement().executeQuery());
    } catch(Exception e){
        System.out.println(e.getMessage());
    }

    return getResultado();
}

public ResultSet listarPorId(int id){
    try{
        sql = 
            "SELECT " +
            "  H.ID AS ID, " +
            "  C.NOME AS CIDADE, " +
            "  E.NOME_RUA AS RUA, " +
            "  E.CEP AS CEP, " +
            "  E.NUMERO_RESIDENCIA AS NUM_RES, " +
            "  H.NOME AS NOME, " +
            "  IFNULL(H.DESCRICAO, '') AS DESCRICAO " +
            "FROM " +
            "  HOTEL H " +
            "JOIN ENDERECO E ON " +
            "  E.ID = H.IDENDERECO " +
            "JOIN CIDADE C ON " +
            "  C.ID = E.ID_CIDADE " +
            "WHERE H.ID = ?";

        setStatement(getConexao().prepareStatement(sql));
        getStatement().setInt(1, id);
        setResultado(getStatement().executeQuery());
    } catch(Exception e){
        System.out.println(e.getMessage());
    }

    return getResultado();
}

public ResultSet listarPorNome(String nome){
    try{
        sql = 
            "SELECT " +
            "  H.ID AS ID, " +
            "  C.NOME AS CIDADE, " +
            "  E.NOME_RUA AS RUA, " +
            "  E.CEP AS CEP, " +
            "  E.NUMERO_RESIDENCIA AS NUM_RES, " +
            "  H.NOME AS NOME, " +
            "  IFNULL(H.DESCRICAO, '') AS DESCRICAO " +
            "FROM " +
            "  HOTEL H " +
            "JOIN ENDERECO E ON " +
            "  E.ID = H.IDENDERECO " +
            "JOIN CIDADE C ON " +
            "  C.ID = E.ID_CIDADE " +
            "WHERE H.NOME LIKE ?";

        setStatement(getConexao().prepareStatement(sql));
        getStatement().setString(1, nome + "%");
        setResultado(getStatement().executeQuery());
    } catch(Exception e){
        System.out.println(e.getMessage());
    }

    return getResultado();
}

public ResultSet listarPorDescricao(String descricao){
    try{
        sql = 
            "SELECT " +
            "  H.ID AS ID, " +
            "  C.NOME AS CIDADE, " +
            "  E.NOME_RUA AS RUA, " +
            "  E.CEP AS CEP, " +
            "  E.NUMERO_RESIDENCIA AS NUM_RES, " +
            "  H.NOME AS NOME, " +
            "  IFNULL(H.DESCRICAO, '') AS DESCRICAO " +
            "FROM " +
            "  HOTEL H " +
            "JOIN ENDERECO E ON " +
            "  E.ID = H.IDENDERECO " +
            "JOIN CIDADE C ON " +
            "  C.ID = E.ID_CIDADE " +
            "WHERE H.DESCRICAO LIKE ?";

        setStatement(getConexao().prepareStatement(sql));
        getStatement().setString(1, descricao + "%");
        setResultado(getStatement().executeQuery());
    } catch(Exception e){
        System.out.println(e.getMessage());
    }

    return getResultado();
}

    
        public ResultSet listarPorRua(String rua) {
        try {
            sql =
                " SELECT                            " +
                "   H.ID AS ID,                     " +
                "   C.NOME AS CIDADE,               " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUMERO_RESIDENCIA AS NUM_RES, " +
                "   H.NOME AS NOME,           " +  
                "   H.DESCRICAO AS DESCRICAO  " +  
                " FROM                              " +
                "   HOTEL H                         " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = H.IDENDERECO             " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE E.NOME_RUA LIKE ?           ";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, rua + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorCep(String cep) {
        try {
            sql =
                " SELECT                            " +
                "   H.ID AS ID,                     " +
                "   C.NOME AS CIDADE,               " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUMERO_RESIDENCIA AS NUM_RES, " +
                "   H.NOME AS NOME,           " +  
                "   H.DESCRICAO AS DESCRICAO  " +  
                " FROM                              " +
                "   HOTEL H                         " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = H.IDENDERECO             " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE E.CEP LIKE ?                ";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, cep + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorNumeroResidencia(String numResidencia) {
        try {
            sql =
                " SELECT                            " +
                "   H.ID AS ID,                     " +
                "   C.NOME AS CIDADE,               " +
                "   E.NOME_RUA AS RUA,              " +
                "   E.CEP AS CEP,                   " +
                "   E.NUMERO_RESIDENCIA AS NUM_RES, " +
                "   H.NOME AS NOME,           " +  
                "   H.DESCRICAO AS DESCRICAO  " +  
                " FROM                              " +
                "   HOTEL H                         " +
                " JOIN ENDERECO E ON                " +
                "   E.ID = H.IDENDERECO             " +
                " JOIN CIDADE C ON                  " +
                "   C.ID = E.ID_CIDADE              " +
                " WHERE E.NUMERO_RESIDENCIA LIKE ?  ";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, numResidencia + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM HOTEL";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
