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
            sql =   "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento";
                    


            setStatement(getConexao().prepareStatement(sql));

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorId(int id) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento" +
                    "where id = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, id);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorCliente(String nomeCliente) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where p.nome like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, nomeCliente + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }


    public ResultSet listarPorNumeroQuarto(String numeroQuarto) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where q.numero_quarto like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, numeroQuarto + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorTipoQuarto(String tipoQuarto) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where q.tipo_quarto like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, tipoQuarto + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorHotel(String nomeHotel) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where h.nome like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, nomeHotel + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorCidade(String nomeCidade) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where c.nome like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, nomeCidade + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorNomeRua(String nomeRua) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where e.nome_rua like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, nomeRua + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorCep(String Cep) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where e.cep like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, Cep + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorNumeroresidencia(String numRes) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where e.numeroresidencia like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, numRes + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorStatus(String status) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where status like ?";

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
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where check_in like ?";

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
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where check_out like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setObject(1, checkOut);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorLavagemRoupa(int LavagemRoupa) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where lr.sim_ou_nao = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, LavagemRoupa);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorComida(int Comida) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where co.sim_ou_nao = ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setInt(1, Comida);

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }

    public ResultSet listarPorPagamento(String tipoPagamento) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where pa.tipo like ?";

            setStatement(getConexao().prepareStatement(sql));

            getStatement().setString(1, tipoPagamento + "%");

            setResultado(getStatement().executeQuery());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return getResultado();
    }
    
    public ResultSet listarPorPreco(Double preco) {
        try {
            sql = "SELECT \n" +
                    "\n" +
                    "	r.id as id,\n" +
                    "	q.numero_quarto as numero_quarto,\n" +
                    "	q.tipo_quarto as tipo_quarto,\n" +
                    "	q.capacidade as capacidade,\n" +
                    "	h.nome as nome_hotel,\n" +
                    "	c.nome as cidade,\n" +
                    "	e.nome_rua as rua,\n" +
                    "	e.cep as cep,\n" +
                    "	e.numeroresidencia as numRes,\n" +
                    "	p.nome as nome_cliente,\n" +
                    "	p.sobrenome as sobrenome_cliente,\n" +
                    "	r.check_in as checkIn,\n" +
                    "	r.check_out as checkOut,\n" +
                    "	r.status as status,\n" +
                    "	lr.sim_ou_nao as lavagem_roupa,\n" +
                    "	co.sim_ou_nao as comida,\n" +
                    "	pa.tipo as forma_pagamento,\n" +
                    "	r.preco as preco\n" +
                    "	\n" +
                    "FROM RESERVA r\n" +
                    "join quarto q on q.id = r.idQuarto \n" +
                    "join hotel h on h.id = q.idHotel \n" +
                    "join endereco e on e.id = h.idEndereco \n" +
                    "join cidade c on c.id = e.idCidade \n" +
                    "join cliente cli on cli.id = r.idCliente  \n" +
                    "join pessoa p on p.id = cli.idPessoa \n" +
                    "join lavagem_roupa lr on lr.id = r.idLavagem_roupa \n" +
                    "join comida co on co.id = r.idComida \n" +
                    "join pagamento pa on pa.id = r.idPagamento"
                    + "where preco = ?";

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
