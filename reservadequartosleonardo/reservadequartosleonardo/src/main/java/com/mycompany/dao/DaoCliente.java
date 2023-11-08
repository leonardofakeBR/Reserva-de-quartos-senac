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
public class DaoCliente extends BancoDeDadosMySql{
    private String sql; 
    
    public Boolean inserir(int id, int idpessoa){
        try{
            sql = "INSERT INTO CLIENTE (ID, IDPESSOA) VALUES (?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idpessoa);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int novoIdpessoa){
        try{
            sql = "UPDATE CLIENTE SET IDPESSOA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(2, id);
            getStatement().setInt(1, novoIdpessoa);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM CLIENTE WHERE ID = ?";
            
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
            sql = "SELECT ID, IDPESSOA FROM CLIENTE";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, IDPESSOA FROM CLIENTE WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorPessoa(int idpessoa){
        try{
            sql = "SELECT ID, IDPESSOA FROM CLIENTE WHERE IDPESSOA = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idpessoa);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
     public ResultSet listarPorIdPessoa(int idPessoa){
        try{
            sql = 
                " SELECT                            " +
                "   ID AS ID,                       " +
                "   IDPESSOA AS CIDADE             " +
                " FROM                              " +
                "   CLIENTE                         " +
                " WHERE IDPESSOA = ?               " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idPessoa);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CLIENTE";
            
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
