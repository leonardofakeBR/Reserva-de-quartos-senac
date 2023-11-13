/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.quarto;

import com.mycompany.dao.DaoHotel;
import com.mycompany.visao.quarto.*;
import com.mycompany.dao.DaoQuarto;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModQuarto;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.35903
 */
public class CadQuarto extends javax.swing.JFrame {

    /**
     * Creates new form CadQuarto
     */
    public CadQuarto() {
        initComponents();
        carregarHoteis();
        
        if(!existeDadosTemporarios()){
            DaoQuarto daoQuarto = new DaoQuarto();

            int id = daoQuarto.buscarProximoId(); 
            if (id >= 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModQuarto){
            int id = ((ModQuarto) DadosTemporarios.tempObject).getId();
            String numero_quarto = ((ModQuarto) DadosTemporarios.tempObject).getNumero_quarto();
            String tipo_quarto = ((ModQuarto) DadosTemporarios.tempObject).getTipo_quarto(); 
            int capacidade = ((ModQuarto) DadosTemporarios.tempObject).getCapacidade(); 
            int idHotel = ((ModQuarto) DadosTemporarios.tempObject).getIdHotel();
            Boolean disponibilidade = ((ModQuarto) DadosTemporarios.tempObject).getDisponibilidade(); 
            Double preco_noite = ((ModQuarto) DadosTemporarios.tempObject).getPreco_noite(); 
            
            tfId.setText(String.valueOf(id));
            tfPreco.setText(String.valueOf(preco_noite));
            tfIdHotel.setText(String.valueOf(idHotel));
            tfCapacidade.setText(String.valueOf(capacidade));
            tfTipo_quarto.setText(String.valueOf(tipo_quarto));
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
//    private void inserir(){
//        DaoQuarto daoQuarto = new DaoQuarto();
//      //int id, String numeroQuarto, String tipoQuarto, int capacidade, Double precoNoite, Boolean disponibilidade, int idHotel  
//        if (daoQuarto.inserir(Integer.parseInt(tfId.getText()), tfNumeroQuarto.getText(), tfTipo_quarto.getText(), Integer.parseInt(tfCapacidade.getText()), Double.parseDouble(tfPreco.getText()), Boolean.parseBoolean(jchbDisponibilidade.get))){
//            JOptionPane.showMessageDialog(null, "Quarto salvo com sucesso!");
//            
//            tfId.setText(String.valueOf(daoQuarto.buscarProximoId()));
//            tfNome.setText("");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possível salvar o quarto!");
//        }
//    }
    
    private void inserir() {
    DaoQuarto daoQuarto = new DaoQuarto();
    
    // int id, String numeroQuarto, String tipoQuarto, int capacidade, Double precoNoite, Boolean disponibilidade, int idHotel
    if (daoQuarto.inserir(
            Integer.parseInt(tfId.getText()),
            tfNumeroQuarto.getText(),
            tfTipo_quarto.getText(),
            Integer.parseInt(tfCapacidade.getText()),
            Double.parseDouble(tfPreco.getText()),
            jchbDisponibilidade.isSelected(),  
            Integer.parseInt(tfIdHotel.getText()))) {  
        JOptionPane.showMessageDialog(null, "Quarto salvo com sucesso!");
        
        tfId.setText(String.valueOf(daoQuarto.buscarProximoId()));
        tfCapacidade.setText("");
        tfIdHotel.setText("");
        tfNumeroQuarto.setText("");
        tfPreco.setText("");
        tfTipo_quarto.setText("");
        jchbDisponibilidade.setSelected(false);
        
    } else {
        JOptionPane.showMessageDialog(null, "Não foi possível salvar o quarto!");
    }
}

    
    private void alterar(){
        DaoQuarto daoQuarto = new DaoQuarto();
        
        if (daoQuarto.alterar(
           Integer.parseInt(tfId.getText()),
            tfNumeroQuarto.getText(),
            tfTipo_quarto.getText(),
            Integer.parseInt(tfCapacidade.getText()),
            Double.parseDouble(tfPreco.getText()),
            jchbDisponibilidade.isSelected(),  
            Integer.parseInt(tfIdHotel.getText()))) {
            JOptionPane.showMessageDialog(null, "Quarto alterado com sucesso!");
            
            tfId.setText(String.valueOf(daoQuarto.buscarProximoId()));
            tfCapacidade.setText("");
            tfIdHotel.setText("");
            tfNumeroQuarto.setText("");
            tfPreco.setText("");
            tfTipo_quarto.setText("");
            jchbDisponibilidade.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o quarto!");
        }
        
        ((ListQuarto) Formularios.listQuarto).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoQuarto daoQuarto = new DaoQuarto();
        
        if (daoQuarto.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Quarto " + tfNumeroQuarto.getText() + " excluído com sucesso!");
            
            tfId.setText(String.valueOf(daoQuarto.buscarProximoId()));
            tfCapacidade.setText("");
            tfIdHotel.setText("");
            tfNumeroQuarto.setText("");
            tfPreco.setText("");
            tfTipo_quarto.setText("");
            jchbDisponibilidade.setSelected(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Quarto!");
        }
        
        ((ListQuarto) Formularios.listQuarto).listarTodos();
        
        dispose();
    }
    
    private void carregarHoteis(){
        try{
            DaoHotel daoHotel = new DaoHotel();

            ResultSet resultSet = daoHotel.listarTodos();

            while(resultSet.next())
                jcbHotel.addItem(resultSet.getString("NOME"));
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
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jcbCapacidade = new javax.swing.JComboBox<>();
        jcbTipo_quarto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        jcbHotel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jchbDisponibilidade = new javax.swing.JCheckBox();
        tfIdHotel = new javax.swing.JTextField();
        tfCapacidade = new javax.swing.JTextField();
        tfTipo_quarto = new javax.swing.JTextField();
        tfNumeroQuarto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDisponibilidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de pais");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jcbCapacidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Duplo Solteiro", "Casal" }));

        jcbTipo_quarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Master", "Deluxe" }));

        jLabel2.setText("Preço por noite");

        jLabel3.setText("Hotel");

        jLabel4.setText("Quarto");

        jchbDisponibilidade.setText("Disponivel");

        jLabel5.setText("Numero do quarto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIdHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTipo_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTipo_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfNumeroQuarto)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addComponent(jchbDisponibilidade)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipo_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipo_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchbDisponibilidade)
                    .addComponent(tfNumeroQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
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

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        DaoQuarto daoQuarto = new DaoQuarto();
        
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            tfId.setText(String.valueOf(daoQuarto.buscarProximoId()));
            tfCapacidade.setText("");
            tfIdHotel.setText("");
            tfNumeroQuarto.setText("");
            tfPreco.setText("");
            tfTipo_quarto.setText("");
            jchbDisponibilidade.setSelected(false);
        }
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            ((ListQuarto) Formularios.listQuarto).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o quarto " + tfNumeroQuarto.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadQuarto = null;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadQuarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbCapacidade;
    private javax.swing.JComboBox<String> jcbHotel;
    private javax.swing.JComboBox<String> jcbTipo_quarto;
    private javax.swing.JCheckBox jchbDisponibilidade;
    private javax.swing.JTextField tfCapacidade;
    private javax.swing.JTextField tfDisponibilidade;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdHotel;
    private javax.swing.JTextField tfNumeroQuarto;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfTipo_quarto;
    // End of variables declaration//GEN-END:variables
}
