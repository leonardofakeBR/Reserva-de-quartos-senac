/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.hotel;

import com.mycompany.visao.hotel.*;
import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoEstadoCivil;
import com.mycompany.dao.DaoHotel;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModHotel;
import com.mycompany.visao.endereco.CadEndereco;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 10156
 */
public class ListHotel extends javax.swing.JFrame {

    /**
     * Creates new form CadHotel
     */
    public ListHotel() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();;
    }

    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableHotel.getModel();
            
            tableHotel.setModel(defaultTableModel);

            DaoHotel daoHotel = new DaoHotel();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoHotel.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String descricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, descricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableHotel.getModel();
            
            tableHotel.setModel(defaultTableModel);

            DaoHotel daoHotel = new DaoHotel();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoHotel.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String descricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, descricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorDescricao(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableHotel.getModel();
            
            tableHotel.setModel(defaultTableModel);

            DaoHotel daoHotel = new DaoHotel();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoHotel.listarPorCep(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String descricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, descricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNumeroResidencia(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableHotel.getModel();
            
            tableHotel.setModel(defaultTableModel);

            DaoHotel daoHotel = new DaoHotel();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoHotel.listarPorNumeroResidencia(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String descricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, descricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableHotel.getModel();
            
            tableHotel.setModel(defaultTableModel);

            DaoHotel daoHotel = new DaoHotel();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoHotel.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cidade = resultSet.getString(2);
                String rua = resultSet.getString(3);
                String cep = resultSet.getString(4);
                String numRes = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String descricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, cidade, rua, cep, numRes, nome, descricao});
            }
        }catch(Exception e){
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
        tableHotel = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableHotel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ENDERECO", "NOME", "DESCRIÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHotelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHotel);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    private void tableHotelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHotelMouseClicked
        try{
            if (evt.getClickCount() == 2){
                //Guarda os dados da hotel
                ModHotel modHotel = new ModHotel();

                modHotel.setId(Integer.parseInt(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 0))));
//                modHotel.setIdEndereco(Integer.parseInt(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 1))));
//                modHotel.setIdEstadoCivil(Integer.parseInt(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 2))));
                modHotel.setNome(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 5)));
                modHotel.setDescricao(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 6)));

                
                DaoEndereco daoEndereco = new DaoEndereco();
                ResultSet resultSet = daoEndereco.listarPorId(Integer.parseInt(tableHotel.getValueAt(tableHotel.getSelectedRow(), 0).toString()));

                int idEndereco = -1;
                while(resultSet.next())
                    idEndereco = resultSet.getInt("ID");

                modHotel.setIdEndereco(idEndereco);
                
                //Guarda os dados do endereço
                ModEndereco modEndereco = new ModEndereco();
                
                modEndereco.setNomeRua(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 2)));
                modEndereco.setCep(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 3)));
                modEndereco.setNumeroResidencia(String.valueOf(tableHotel.getValueAt(tableHotel.getSelectedRow(), 4)));
                
                DadosTemporarios.tempObject = (ModHotel) modHotel;
                DadosTemporarios.tempObject2 = (ModEndereco) modEndereco;
                
                CadHotel cadHotel = new CadHotel();
                cadHotel.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tableHotelMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed

    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listHotel = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
                switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId();
                break;
            case 2:
                listarPorDescricao();
                break;
            case 3:
                listarPorNumeroResidencia();
                break;
            case 4:
                listarPorNome();
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
            java.util.logging.Logger.getLogger(ListHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableHotel;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
