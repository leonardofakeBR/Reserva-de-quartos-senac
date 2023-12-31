/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.reserva;

import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoComida;
import com.mycompany.dao.DaoLavagem_roupa;
import com.mycompany.dao.DaoPagamento;
import com.mycompany.dao.DaoQuarto;
import com.mycompany.dao.DaoReserva;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModReserva;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.35903
 */
public class CadReserva extends javax.swing.JFrame {

    /**
     * Creates new form CadReserva
     */
    public CadReserva() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoReserva daoReserva = new DaoReserva();
            DaoLavagem_roupa daoLavagem_roupa = new DaoLavagem_roupa();
            DaoComida daoComida = new DaoComida();
            DaoPagamento daoPagamento = new DaoPagamento();

            int id = daoReserva.buscarProximoId();
            int idlavagem = daoLavagem_roupa.buscarProximoId();
            int idcomida = daoComida.buscarProximoId();
            int idpagamento = daoPagamento.buscarProximoId();
            
            if (id >= 0)
                tfId.setText(String.valueOf(id));
                tfIdLavagem_roupa.setText(String.valueOf(idlavagem));
                tfIdComida.setText(String.valueOf(idcomida));
                tfIdPagamento.setText(String.valueOf(idcomida));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        tfIdCliente.setVisible(false);
        tfIdComida.setVisible(false);
        tfIdLavagem_roupa.setVisible(false);
        tfIdPagamento.setVisible(false);
        tfIdQuarto.setVisible(false);
        tfpreconoite.setVisible(false);

        Double precoNoite = Double.parseDouble("0");
        
        calculaTotalCompra(precoNoite);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModReserva){
            int id = ((ModReserva) DadosTemporarios.tempObject).getId();
            LocalDate checkIn = ((ModReserva) DadosTemporarios.tempObject).getCheckIn();
            
            tfId.setText(String.valueOf(id));
            tfCheckIn.setText(String.valueOf(checkIn));
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoReserva daoReserva = new DaoReserva();
        
        DaoPagamento daoPagamento = new DaoPagamento();
        DaoLavagem_roupa daoLavagem_roupa = new DaoLavagem_roupa();
        DaoComida daoComida = new DaoComida();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        // Define um formato para exibição
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Formata a data e hora para uma string
        String dataHoraFormatada = dataHoraAtual.format(formatter2);
        
        if(daoLavagem_roupa.inserir(Integer.parseInt(tfIdLavagem_roupa.getText()), jchbLavagem.isSelected(), dataHoraAtual)){}
        else
            JOptionPane.showMessageDialog(null, "Erro ao salvar a Lavagem da roupa!");
        
        if(daoComida.inserir(Integer.parseInt(tfIdComida.getText()), jchbComida.isSelected(), dataHoraAtual)){}
        else
            JOptionPane.showMessageDialog(null, "Erro ao salvar a Comida!");
        
        if(daoPagamento.inserir(Integer.parseInt(tfIdPagamento.getText()), (String) jcbPagamento.getSelectedItem())){}
        else 
            JOptionPane.showMessageDialog(null, "Erro ao salvar pagamento!");
            
        if (daoReserva.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCliente.getText()), Integer.parseInt(tfIdQuarto.getText()), LocalDate.parse(tfCheckIn.getText(), formatter), LocalDate.parse(tfCheckOut.getText(), formatter), (String) jcbStatus.getSelectedItem(), Integer.parseInt(tfIdLavagem_roupa.getText()), Integer.parseInt(tfIdComida.getText()), Integer.parseInt(tfIdPagamento.getText()), Double.parseDouble(labelPreco.getText()))){
            JOptionPane.showMessageDialog(null, "Reserva salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoReserva.buscarProximoId()));
            tfIdCliente.setText(String.valueOf( new DaoCliente().buscarProximoId()));
            tfIdComida.setText(String.valueOf(daoComida.buscarProximoId()));
            tfIdLavagem_roupa.setText(String.valueOf(daoLavagem_roupa.buscarProximoId()));
            tfIdPagamento.setText(String.valueOf(daoPagamento.buscarProximoId()));
            tfCheckIn.setText("yyyy-MM-dd");
            tfCheckOut.setText("yyyy-MM-dd");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o reserva!");
        }
    }
    
    private void alterar(){
        DaoReserva daoReserva = new DaoReserva();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        if (daoReserva.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCliente.getText()), Integer.parseInt(tfIdQuarto.getText()), LocalDate.parse(tfCheckIn.getText(), formatter), LocalDate.parse(tfCheckOut.getText(), formatter), (String) jcbPagamento.getSelectedItem(), Integer.parseInt(tfIdLavagem_roupa.getText()), Integer.parseInt(tfIdComida.getText()), Integer.parseInt(tfIdPagamento.getText()), Double.parseDouble(labelPreco.getText()))){
            JOptionPane.showMessageDialog(null, "Reserva alterado com sucesso!");
            
            tfId.setText("");
            tfCheckIn.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o reserva!");
        }
        
        ((ListReserva) Formularios.listReserva).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoReserva daoReserva = new DaoReserva();
        
        if (daoReserva.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Reserva excluída com sucesso!");
            
            tfId.setText("");
            tfCheckIn.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a reserva!");
        }
        
        ((ListReserva) Formularios.listReserva).listarTodos();
        
        dispose();
    }
    
    private void calculaTotalCompra(Double preco){
        try{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate checkIn = LocalDate.parse( tfCheckIn.getText());
        LocalDate checkOut = LocalDate.parse(tfCheckOut.getText());
        
        long diferencaEmDias = ChronoUnit.DAYS.between(checkIn, checkOut);
        Double total = preco * diferencaEmDias;
        
        if(jchbComida.isSelected()){
        total += 50;
        }
        
        if(jchbLavagem.isSelected()){
        total += 50;
        }
        
        labelPreco.setText(String.valueOf(total));
        }catch(Exception e){}
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
        jcbQuarto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jchbLavagem = new javax.swing.JCheckBox();
        jchbComida = new javax.swing.JCheckBox();
        jcbPagamento = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelPreco = new javax.swing.JLabel();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfIdQuarto = new javax.swing.JTextField();
        tfIdCliente = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        tfCheckOut = new javax.swing.JTextField();
        tfCheckIn = new javax.swing.JTextField();
        jcbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfIdLavagem_roupa = new javax.swing.JTextField();
        tfIdComida = new javax.swing.JTextField();
        tfIdPagamento = new javax.swing.JTextField();
        tfpreconoite = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quarto" }));
        jcbQuarto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbQuartoItemStateChanged(evt);
            }
        });

        jLabel1.setText("Check_in");

        jLabel2.setText("Check_out");

        jchbLavagem.setText("Lavagem da roupa");

        jchbComida.setText("Comida");

        jcbPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forma de Pagamento" }));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel3.setText("Preco:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");

        tfCheckOut.setText("YYYY-MM-DD");

        tfCheckIn.setText("YYYY-MM-DD");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não pago", "Pago" }));
        jcbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusActionPerformed(evt);
            }
        });

        jLabel7.setText("Status da reserva");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfIdComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfIdQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jchbLavagem)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(jLabel1))
                                                    .addComponent(tfCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2)))
                                            .addComponent(jchbComida)
                                            .addComponent(jcbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(tfpreconoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfIdLavagem_roupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(tfIdPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfIdQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfIdLavagem_roupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfIdComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))
                        .addComponent(jchbLavagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jchbComida)
                            .addComponent(tfIdPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfpreconoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAcao)
                        .addComponent(btnExcluir)))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbStatusActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbQuartoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbQuartoItemStateChanged
        // TODO add your handling code here:
        try{
            DaoQuarto daoQuarto = new DaoQuarto();

            ResultSet resultSet = daoQuarto.PegarPrecoNoite(Integer.parseInt(tfIdQuarto.getText()));
            Double precoNoite = resultSet.getDouble("PRECO_NOITE");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao pegar Preco noite.");
        }
    }//GEN-LAST:event_jcbQuartoItemStateChanged

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
            java.util.logging.Logger.getLogger(CadReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcbPagamento;
    private javax.swing.JComboBox<String> jcbQuarto;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JCheckBox jchbComida;
    private javax.swing.JCheckBox jchbLavagem;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JTextField tfCheckIn;
    private javax.swing.JTextField tfCheckOut;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfIdComida;
    private javax.swing.JTextField tfIdLavagem_roupa;
    private javax.swing.JTextField tfIdPagamento;
    private javax.swing.JTextField tfIdQuarto;
    private javax.swing.JTextField tfpreconoite;
    // End of variables declaration//GEN-END:variables
}
