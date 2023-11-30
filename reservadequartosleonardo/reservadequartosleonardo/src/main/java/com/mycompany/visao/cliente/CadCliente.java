/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.cliente;

import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCliente;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.35903
 */
public class CadCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadCliente
     */
    public CadCliente() {
        initComponents();
        
        carregarPessoas();
        
        if(!existeDadosTemporarios()){
            DaoCliente daoCliente = new DaoCliente();

            int id = daoCliente.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdPessoa();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfIdPessoa.setVisible(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModCliente){
            int id = ((ModCliente) DadosTemporarios.tempObject).getId();
            int id_pessoa = ((ModCliente) DadosTemporarios.tempObject).getId_pessoa();
            
            tfId.setText(String.valueOf(id));
            tfIdPessoa.setText(String.valueOf(id_pessoa));
            
            try{
                DaoPessoa daoPessoa = new DaoPessoa();
                ResultSet resultSet = daoPessoa.listarPorId(id_pessoa);
                resultSet.next();
                String pais = resultSet.getString("ESTADO");
                int index = 0;
                for(int i = 0; i < jcbPessoa.getItemCount(); i++){
                    if(jcbPessoa.getItemAt(i).equals(pais)){
                        index = i;
                        break;
                    }
                }
                jcbPessoa.setSelectedIndex(index);
            }catch(Exception e){}
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdPessoa.getText()))){
            JOptionPane.showMessageDialog(null, "Cliente salva com sucesso!");
            
            tfId.setText(String.valueOf(daoCliente.buscarProximoId())); 
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o cliente!");
        }
    }
    
    private void alterar(){
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.alterar(Integer.parseInt(tfId.getText()),Integer.parseInt(tfIdPessoa.getText()))){
            JOptionPane.showMessageDialog(null, "Cliente alterada com sucesso!");
            
            tfId.setText("");
            tfIdPessoa.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cliente!");
        }
        
        ((ListCliente) Formularios.listCliente).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Cliente " + tfId.getText() + " excluído com sucesso!");
            
            tfId.setText("");
            tfIdPessoa.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente!");
        }
        
        ((ListCliente) Formularios.listCliente).listarTodos();
        
        dispose();
    }
    
    private void carregarPessoas(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();

            ResultSet resultSet = daoPessoa.listarTodos();

            while(resultSet.next()){
                jcbPessoa.addItem(resultSet.getString("ESTADO"));
            }
        }catch(Exception e){
            
        }
    }
    
    private void recuperaIdPessoa(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();
            ResultSet resultSet = daoPessoa.listarPorNome(jcbPessoa.getSelectedItem().toString());
            
            resultSet.next();
            tfIdPessoa.setText(resultSet.getString("ID"));
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
        jLabel3 = new javax.swing.JLabel();
        jcbPessoa = new javax.swing.JComboBox<>();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfIdPessoa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel3.setText("Pessoa");

        jcbPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPessoaItemStateChanged(evt);
            }
        });
        jcbPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPessoaActionPerformed(evt);
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

        tfIdPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPessoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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

    private void tfIdPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPessoaActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT)
            inserir();
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPessoaItemStateChanged
        recuperaIdPessoa();
    }//GEN-LAST:event_jcbPessoaItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadCliente = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o cliente " + tfId.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPessoaActionPerformed

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
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbPessoa;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdPessoa;
    // End of variables declaration//GEN-END:variables
}
