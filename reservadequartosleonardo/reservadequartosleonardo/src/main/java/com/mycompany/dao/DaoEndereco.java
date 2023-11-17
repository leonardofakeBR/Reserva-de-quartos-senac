/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getConexao;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getStatement;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setStatement;
import java.sql.ResultSet;

/**
 *
 * @author leonardo.35903
 */
public class DaoEndereco extends BancoDeDadosMySql{
    
    String sql;
    
    public Boolean inserir(int id, int idCidade, String nomeRua, String cep, String numeroResidencia){
        try{
            sql = "INSERT INTO ENDERECO (ID, IDCIDADE, NOME_RUA, CEP, NUMERORESIDENCIA) VALUES (?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idCidade);
            getStatement().setString(3, nomeRua);
            getStatement().setString(4, cep);
            getStatement().setString(5, numeroResidencia);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int idNovaCidade, String novoNomeRua, String novoCep, String novoNumeroResidencia){
        try{
            sql = "UPDATE ENDERECO SET IDCIDADE = ?, NOME_RUA = ?, CEP = ?, NUMERORESIDENCIA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idNovaCidade);
            getStatement().setString(2, novoNomeRua);
            getStatement().setString(3, novoCep);
            getStatement().setString(4, novoNumeroResidencia);
            getStatement().setInt(5, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM ENDERECO WHERE ID = ?";
            
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
                " SELECT                            " +
                "   EN.ID,                          " +
                "   CID.NOME AS CIDADE,             " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CEP,                  " +
                "   EN.NUMERORESIDENCIA AS NUMRES " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.IDCIDADE           " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   CID.NOME AS CIDADE,             " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CEP,                  " +
                "   EN.NUMERORESIDENCIA AS NUMRES " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.IDCIDADE           " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNomeRua(String nomeRua){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   CID.NOME AS CIDADE,             " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CEP,                  " +
                "   EN.NUMERORESIDENCIA AS NUMRES " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.IDCIDADE           " +
                " WHERE                             " +
                "   EN.NOME_RUA LIKE ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nomeRua + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCep(String cep){
        try{
            sql = 
               " SELECT                            " +
                "   EN.ID,                          " +
                "   CID.NOME AS CIDADE,             " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CEP,                  " +
                "   EN.NUMERORESIDENCIA AS NUMRES " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.IDCIDADE           " +
                " WHERE                             " +
                "   EN.CEP LIKE ?                   " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cep + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNumeroResidencia(String numeroResidencia){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   CID.NOME AS CIDADE,             " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CEP,                  " +
                "   EN.NUMERORESIDENCIA AS NUMRES " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.IDCIDADE           " +
                " WHERE                             " +
                "   EN.NUMERORESIDENCIA LIKE ?     " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, numeroResidencia + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorCidade(String cidade){
        try{
            sql = 
                " SELECT                            " +
                "   EN.ID,                          " +
                "   CID.NOME AS CIDADE,             " +
                "   EN.NOME_RUA AS RUA,             " +
                "   EN.CEP AS CEP,                  " +
                "   EN.NUMERORESIDENCIA AS NUMRES " +
                " FROM                              " +
                "   ENDERECO EN                     " +
                " JOIN CIDADE CID ON                " +
                "   CID.ID = EN.IDCIDADE           " +
                " WHERE                             " +
                "   CID.NOME LIKE ?                 " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cidade + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ENDERECO";
            
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
