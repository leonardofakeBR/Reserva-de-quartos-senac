/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.reserva;

import com.mycompany.visao.pagamento.*;
import com.mycompany.visao.reserva.*;
import com.mycompany.dao.DaoReserva;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModQuarto;
import com.mycompany.modelo.ModReserva;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonardo.35903
 */
public class ListReserva extends javax.swing.JFrame {

    /**
     * Creates new form ListReserva
     */
    public ListReserva() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

//    public void listarTodos(){
//        try{
//            //Pega o model da tabela definido no design
//            DefaultTableModel defaultTableModel = (DefaultTableModel) tableReserva.getModel();
//            
//            tableReserva.setModel(defaultTableModel);
//
//            DaoReserva daoReserva = new DaoReserva();
//
//            //Atribui o resultset retornado a uma variável para ser usada.
//            ResultSet resultSet = daoReserva.listarTodos();
//            
//            defaultTableModel.setRowCount(0);
//            while (resultSet.next()){
//                String id = resultSet.getString(1);
//                String numero_quarto = resultSet.getString(2);
//                String tipo_quarto = resultSet.getString(3);
//                String capacidade = resultSet.getString(4);
//                String nome_hotel = resultSet.getString(5);
//                String cidade = resultSet.getString(6);
//                String rua = resultSet.getString(7);
//                String cep = resultSet.getString(8);
//                String numRes = resultSet.getString(9);
//                String nome_cliente = resultSet.getString(10);
//                String sobrenome_cliente = resultSet.getString(11);
//                String checkIn = resultSet.getString(12);
//                String checkOut = resultSet.getString(13);
//                String status = resultSet.getString(14);
//                String simnao_lavagem_roupa = resultSet.getString(15);
//                String simnao_comida = resultSet.getString(16);
//                String tipo_pagamento = resultSet.getString(17);
//                String preco = resultSet.getString(18);
//                
//                
//                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, nome_hotel, cidade, rua, cep, numRes, nome_cliente, sobrenome_cliente, checkIn, checkOut, 
//                    status, simnao_lavagem_roupa, simnao_comida, tipo_pagamento, preco });
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public void listarPorId(int pId){
//        try{
//            //Define o model da tabela.
//            DefaultTableModel defaultTableModel = (DefaultTableModel) tableReserva.getModel();
//
//            tableReserva.setModel(defaultTableModel);
//
//            DaoReserva daoReserva = new DaoReserva();
//
//            //Atribui o resultset retornado a uma variável para ser usada.
//            ResultSet resultSet = daoReserva.listarPorId(pId);
//            
//            defaultTableModel.setRowCount(0);
//            while (resultSet.next()){
//                String id = resultSet.getString(1);
//                String numero_quarto = resultSet.getString(2);
//                String tipo_quarto = resultSet.getString(3);
//                String capacidade = resultSet.getString(4);
//                String nome_hotel = resultSet.getString(5);
//                String cidade = resultSet.getString(6);
//                String rua = resultSet.getString(7);
//                String cep = resultSet.getString(8);
//                String numRes = resultSet.getString(9);
//                String nome_cliente = resultSet.getString(10);
//                String sobrenome_cliente = resultSet.getString(11);
//                String checkIn = resultSet.getString(12);
//                String checkOut = resultSet.getString(13);
//                String status = resultSet.getString(14);
//                String simnao_lavagem_roupa = resultSet.getString(15);
//                String simnao_comida = resultSet.getString(16);
//                String tipo_pagamento = resultSet.getString(17);
//                String preco = resultSet.getString(18);
//                
//                
//                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, nome_hotel, cidade, rua, cep, numRes, nome_cliente, sobrenome_cliente, checkIn, checkOut, 
//                    status, simnao_lavagem_roupa, simnao_comida, tipo_pagamento, preco });
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public void listarPorTipo(String pTipo){
//        try{
//            //Define o model da tabela.
//            DefaultTableModel defaultTableModel = (DefaultTableModel) tableReserva.getModel();
//            
//            tableReserva.setModel(defaultTableModel);
//
//            DaoReserva daoReserva = new DaoReserva();
//
//            //Atribui o resultset retornado a uma variável para ser usada.
//            ResultSet resultSet = daoReserva.listarPorTipo(pTipo);
//            
//            defaultTableModel.setRowCount(0);
//            while (resultSet.next()){
//                String id = resultSet.getString(1);
//                String numero_quarto = resultSet.getString(2);
//                String tipo_quarto = resultSet.getString(3);
//                String capacidade = resultSet.getString(4);
//                String nome_hotel = resultSet.getString(5);
//                String cidade = resultSet.getString(6);
//                String rua = resultSet.getString(7);
//                String cep = resultSet.getString(8);
//                String numRes = resultSet.getString(9);
//                String nome_cliente = resultSet.getString(10);
//                String sobrenome_cliente = resultSet.getString(11);
//                String checkIn = resultSet.getString(12);
//                String checkOut = resultSet.getString(13);
//                String status = resultSet.getString(14);
//                String simnao_lavagem_roupa = resultSet.getString(15);
//                String simnao_comida = resultSet.getString(16);
//                String tipo_pagamento = resultSet.getString(17);
//                String preco = resultSet.getString(18);
//                
//                
//                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, nome_hotel, cidade, rua, cep, numRes, nome_cliente, sobrenome_cliente, checkIn, checkOut, 
//                    status, simnao_lavagem_roupa, simnao_comida, tipo_pagamento, preco });
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
    
    public void preencherTabela(ResultSet resultSet) {
    try {
        // Define o model da tabela.
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableReserva.getModel();

        tableReserva.setModel(defaultTableModel);

        // Limpa as linhas existentes na tabela
        defaultTableModel.setRowCount(0);

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String numero_quarto = resultSet.getString(2);
            String tipo_quarto = resultSet.getString(3);
            String capacidade = resultSet.getString(4);
            String nome_hotel = resultSet.getString(5);
            String cidade = resultSet.getString(6);
            String rua = resultSet.getString(7);
            String cep = resultSet.getString(8);
            String numRes = resultSet.getString(9);
            String nome_cliente = resultSet.getString(10);
            String sobrenome_cliente = resultSet.getString(11);
            String checkIn = resultSet.getString(12);
            String checkOut = resultSet.getString(13);
            String status = resultSet.getString(14);
            String simnao_lavagem_roupa = resultSet.getString(15);
            String simnao_comida = resultSet.getString(16);
            String tipo_pagamento = resultSet.getString(17);
            String preco = resultSet.getString(18);

            defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, nome_hotel, cidade, rua, cep, numRes, nome_cliente, sobrenome_cliente, checkIn, checkOut,
                    status, simnao_lavagem_roupa, simnao_comida, tipo_pagamento, preco});
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    
    public void listarTodos() {
    try {
        DaoReserva daoReserva = new DaoReserva();
        ResultSet resultSet = daoReserva.listarTodos();
        preencherTabela(resultSet);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void listarPorId(int pId) {
    try {
        DaoReserva daoReserva = new DaoReserva();
        ResultSet resultSet = daoReserva.listarPorId(pId);
        preencherTabela(resultSet);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void listarPorTipo(String pTipo) {
    try {
        DaoReserva daoReserva = new DaoReserva();
        ResultSet resultSet = daoReserva.listarPorTipoQuarto(pTipo);
        preencherTabela(resultSet);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

//defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, nome_hotel, cidade, rua, cep, numRes, nome_cliente, sobrenome_cliente, checkIn, checkOut,
//                    status, simnao_lavagem_roupa, simnao_comida, tipo_pagamento, preco});

public void listarPorNumero_quarto(String pNumero_quarto) {
    try {
        DaoReserva daoReserva = new DaoReserva();
        ResultSet resultSet = daoReserva.listarPorNumeroQuarto(pNumero_quarto);
        preencherTabela(resultSet);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReserva = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME" }));

        tableReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Numero do quarto", "Tipo do quarto", "Capacidade", "Nome do hotel", "Cidade do hotel", "Rua do hotel", "Cep do hotel", "Numero do Hotel", "Nome do cliente", "Sobrenome do cliente", "CheckIn", "CheckOut", "Status", "Lavagem Roupa", "Comida", "Pagamento", "Preco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReserva);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 1658, Short.MAX_VALUE))
                            .addComponent(btnBuscar))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listReserva = null;
    }//GEN-LAST:event_formWindowClosed

    private void tableReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReservaMouseClicked
        if (evt.getClickCount() == 2){
            ModReserva modReserva = new ModReserva();
            ModQuarto modQuarto = new ModQuarto();

            modReserva.setId(Integer.parseInt(String.valueOf(tableReserva.getValueAt(tableReserva.getSelectedRow(), 0))));
            modQuarto.setTipo_quarto(String.valueOf(tableReserva.getValueAt(tableReserva.getSelectedRow(), 1)));

            DadosTemporarios.tempObject = (ModReserva) modReserva;

            CadReserva cadReserva = new CadReserva();
            cadReserva.setVisible(true);
        }
    }//GEN-LAST:event_tableReservaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
            case 2:
                listarPorTipo(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableReserva;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
