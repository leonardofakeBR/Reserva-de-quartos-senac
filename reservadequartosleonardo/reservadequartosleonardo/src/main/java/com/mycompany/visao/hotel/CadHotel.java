/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.hotel;

import com.mycompany.visao.hotel.*;
import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoEstadoCivil;
import com.mycompany.dao.DaoHotel;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModHotel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 10156
 */
public class CadHotel extends javax.swing.JFrame {

    /**
     * Creates new form ListHotel
     */
    public CadHotel() {
        initComponents();
        
        carregarCidades();
        
        if(!existeDadosTemporarios()){
            DaoHotel daoHotel = new DaoHotel();
            DaoEndereco daoEndereco = new DaoEndereco();
            DaoCliente daoCliente = new DaoCliente();
            
            int id = daoHotel.buscarProximoId(); 
            int idEnd = daoEndereco.buscarProximoId();
            int idCli = daoCliente.buscarProximoId();
            if (id > 0){
                tfIdPessoa.setText(String.valueOf(id));
                tfIdEndereco.setText(String.valueOf(idEnd));
            }
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdCidade();
        
        setLocationRelativeTo(null);
        
        tfIdPessoa.setEnabled(false);
        
        setExtendedState(MAXIMIZED_BOTH);
        

        tfIdCidade.setVisible(false);

    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModHotel){
            int id = ((ModHotel) DadosTemporarios.tempObject).getId();
            int idEndereco = ((ModHotel) DadosTemporarios.tempObject).getIdEndereco();
            String nome = ((ModHotel) DadosTemporarios.tempObject).getNome();
            String descricao = ((ModHotel) DadosTemporarios.tempObject).getDescricao();
            
            tfIdPessoa.setText(String.valueOf(id));
            tfIdEndereco.setText(String.valueOf(idEndereco));

            tfNome.setText(nome);
            jTextArea1.setText(descricao);
            
            
            //
            try{
                DaoEndereco daoEndereco = new DaoEndereco();
                ResultSet resultSet = daoEndereco.listarPorId(idEndereco);
                resultSet.next();
                String cidade = resultSet.getString("CIDADE");
                int index = 0;
                for(int i = 0; i < jcbCidade.getItemCount(); i++){
                    if(jcbCidade.getItemAt(i).equals(cidade)){
                        index = i;
                        break;
                    }
                }
                jcbCidade.setSelectedIndex(index);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            //
            
            
            String rua = ((ModEndereco) DadosTemporarios.tempObject2).getNomeRua();
            String cep = ((ModEndereco) DadosTemporarios.tempObject2).getCep();
            String numRes = ((ModEndereco) DadosTemporarios.tempObject2).getNumeroResidencia();
            
            tfRua.setText(rua);
            tfCep.setText(cep);
            tfNumero.setText(numRes);
            
            DadosTemporarios.tempObject = null;
            DadosTemporarios.tempObject2 = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoHotel daoHotel = new DaoHotel();
        DaoEndereco daoEndereco = new DaoEndereco();
        
        
        if (daoHotel.inserir(Integer.parseInt(tfIdPessoa.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNome.getText(), jTextArea1.getText())){
            JOptionPane.showMessageDialog(null, "Hotel salva com sucesso!");
            
            tfIdPessoa.setText(String.valueOf(daoHotel.buscarProximoId()));
            tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));
            tfNome.setText("");
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a hotel!");
        }
    
    }
    
    private void inserirEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.inserir(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
            JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
            
            tfRua.setText("");
            tfNumero.setText("");
            tfCep.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
        }
    }
    
    private void alterar(){
        DaoHotel daoHotel = new DaoHotel();
        
        if (daoHotel.alterar(Integer.parseInt(tfIdPessoa.getText()), Integer.parseInt(tfIdEndereco.getText()), tfNome.getText(), jTextArea1.getText())){
            JOptionPane.showMessageDialog(null, "Hotel alterada com sucesso!");
            
            //tfIdEndereco.setText(String.valueOf(daoEndereco.buscarProximoId()));          
            tfNome.setText("");
            jTextArea1.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a hotel!");
        }
        
        ((ListHotel) Formularios.listHotel).listarTodos();
        
        dispose();
    }
    
    private void alterarEndereco(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.alterar(Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
            JOptionPane.showMessageDialog(null, "Endereço alterado com sucesso!");
            
            tfRua.setText("");
            tfCep.setText("");
            tfNumero.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o endereço!");
        }
    }
    
    private void excluir(){
        DaoHotel daoHotel = new DaoHotel();
        
        if (daoHotel.excluir(Integer.parseInt(tfIdPessoa.getText())))
            JOptionPane.showMessageDialog(null, "Hotel excluída com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a hotel!");
        
        ((ListHotel) Formularios.listHotel).listarTodos();
        
        dispose();
    }
    
    private void excluirEndereco(){
        
        DaoEndereco daoEndereco = new DaoEndereco();

        if (daoEndereco.excluir(Integer.parseInt(tfIdEndereco.getText()))){

        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereco!");
        }
    }
    
    
    private void carregarCidades(){
        try{
            DaoCidade daoCidade = new DaoCidade();

            ResultSet resultSet = daoCidade.listarTodos();

            while(resultSet.next())
                jcbCidade.addItem(resultSet.getString("CIDADE"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    private void recuperaIdCidade(){
        try{
            DaoCidade daoCidade = new DaoCidade();
            ResultSet resultSet = daoCidade.listarPorNome(jcbCidade.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCidade.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
//        private void recuperaIdCliente(){
//        try{
//            DaoCliente daoCliente = new DaoCliente();
//            ResultSet resultSet = daoCliente.listarPorHotel(jcbEstadoCivil.getSelectedItem().toString());
//            
//            resultSet.next();
//            tfIdEstadoCivil.setText(resultSet.getString("ID"));
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
    
    private boolean camposObrigatoriosPreenchidos(JTextField campos[]){
        boolean b = true;
        
        for(int i = 0; i < campos.length; i++){
            if(campos[i].getText().equals("")){
                JOptionPane.showMessageDialog(null, "O campo " + campos[i].getToolTipText() + " é obrigatório!");
                campos[i].requestFocus();
                b = false;
                break;
            }
        }
        
        return b;
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
        tfIdPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        tfIdEndereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        tfIdCidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de endereço");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        tfIdPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPessoaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome");

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

        jLabel16.setText("Hotel");

        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });

        tfIdEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdEnderecoActionPerformed(evt);
            }
        });

        jLabel14.setText("Número");

        tfRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRuaActionPerformed(evt);
            }
        });

        jLabel10.setText("ID");

        jLabel13.setText("CEP");

        jLabel12.setText("Rua");

        jLabel11.setText("Cidade");

        jLabel15.setText("Endereço");

        jLabel2.setText("Descrição");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel6))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(343, 343, 343)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15)
                                                    .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel11)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(284, 284, 284)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))
                            .addComponent(jLabel2))
                        .addGap(0, 130, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEstadoCivilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoCivilItemStateChanged

    }//GEN-LAST:event_jcbEstadoCivilItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadHotel = null;
    }//GEN-LAST:event_formWindowClosed

    private void tfIdEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdEnderecoActionPerformed

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha =
        JOptionPane.showConfirmDialog(
            null,
            "Deseja realmente excluir a hotel?");

        if(escolha == JOptionPane.YES_OPTION){
            excluir();
            excluirEndereco();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if(camposObrigatoriosPreenchidos(new JTextField[]{tfRua, tfCep, tfNumero, tfNome})){
            if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
                inserirEndereco();
                inserir();
            }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
                alterarEndereco();
                alterar();
            }
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void tfIdPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPessoaActionPerformed

    private void tfRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRuaActionPerformed

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
            java.util.logging.Logger.getLogger(CadHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfIdEndereco;
    private javax.swing.JTextField tfIdPessoa;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables
}