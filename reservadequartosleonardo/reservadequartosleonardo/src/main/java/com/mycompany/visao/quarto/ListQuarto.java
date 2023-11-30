/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.quarto;

import com.mycompany.dao.DaoQuarto;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModQuarto;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonardo.35903
 */
public class ListQuarto extends javax.swing.JFrame {

    /**
     * Creates new form ListQuarto
     */
    public ListQuarto() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                
                defaultTableModel.addRow(new Object[]{id, nome});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pId){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();

            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();
            
//ID, NUMERO_QUARTO, TIPO_QUARTO, CAPACIDADE, PRECO_NOITE, DISPONIBILIDADE, ID_HOTEL

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorCapacidade(int pCapacidade){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorCapacidade(pCapacidade);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
   
        public void listarPorNumero(String pNumero){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorNumeroQuarto(pNumero);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

            public void listarPorDisponibilidade(Boolean pDisponibilidade){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorDisponibilidade(pDisponibilidade);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
       

       public void listarPorDisponibilidade(int pIdHotel){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorIdHotel(pIdHotel);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }    
   
       public void listarPorPrecoNoite(Double pPrecoNoite){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorPrecoNoite(pPrecoNoite);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
       
       public void listarPorDisponibilidade(String pTipoQuarto){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableQuarto.getModel();
            
            tableQuarto.setModel(defaultTableModel);

            DaoQuarto daoQuarto = new DaoQuarto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoQuarto.listarPorTipoQuarto(pTipoQuarto);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String numero_quarto = resultSet.getString(2);
                String tipo_quarto = resultSet.getString(3);
                String capacidade = resultSet.getString(4);
                String preco_noite = resultSet.getString(5);
                String disponibilidade = resultSet.getString(5);
                String id_hotel = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, numero_quarto, tipo_quarto, capacidade, preco_noite, disponibilidade, id_hotel});
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
        tableQuarto = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME" }));

        tableQuarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableQuarto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQuartoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableQuarto);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listQuarto = null;
    }//GEN-LAST:event_formWindowClosed

    private void tableQuartoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuartoMouseClicked
        if (evt.getClickCount() == 2){
            ModQuarto modQuarto = new ModQuarto();

            modQuarto.setId(Integer.parseInt(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 0))));
            modQuarto.setCapacidade(Integer.parseInt(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 1))));
            modQuarto.setDisponibilidade(Boolean.parseBoolean(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 2))));
            modQuarto.setIdHotel(Integer.parseInt(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 3))));
            modQuarto.setNumero_quarto(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 4)));
            modQuarto.setPreco_noite(Double.parseDouble(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 5))));
            modQuarto.setTipo_quarto(String.valueOf(tableQuarto.getValueAt(tableQuarto.getSelectedRow(), 6)));
            

            DadosTemporarios.tempObject = (ModQuarto) modQuarto;

            CadQuarto cadQuarto = new CadQuarto();
            cadQuarto.setVisible(true);
        }
    }//GEN-LAST:event_tableQuartoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
            case 2:
                listarPorCapacidade(Integer.parseInt(tfFiltro.getText()));
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
            java.util.logging.Logger.getLogger(ListQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListQuarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableQuarto;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
