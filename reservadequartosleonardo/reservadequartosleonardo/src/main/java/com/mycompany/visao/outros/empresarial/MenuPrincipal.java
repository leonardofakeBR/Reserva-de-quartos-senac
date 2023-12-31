/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros.empresarial;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.visao.cidade.CadCidade;
import com.mycompany.visao.cidade.ListCidade;
import com.mycompany.visao.endereco.CadEndereco;
import com.mycompany.visao.endereco.ListEndereco;
import com.mycompany.visao.estado.CadEstado;
import com.mycompany.visao.estado.ListEstado;
import com.mycompany.visao.estadocivil.CadEstadoCivil;
import com.mycompany.visao.estadocivil.ListEstadoCivil;
import com.mycompany.visao.hotel.CadHotel;
import com.mycompany.visao.hotel.ListHotel;
import com.mycompany.visao.pais.CadPais;
import com.mycompany.visao.pais.ListPais;
import com.mycompany.visao.pessoa.CadPessoa;
import com.mycompany.visao.pessoa.ListPessoa;
import com.mycompany.visao.quarto.CadQuarto;
import com.mycompany.visao.quarto.ListQuarto;
import com.mycompany.visao.reserva.CadReserva;
import com.mycompany.visao.reserva.ListReserva;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.35903
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        if (!BancoDeDadosMySql.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);
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

        menuBar = new javax.swing.JMenuBar();
        mnCadastro = new javax.swing.JMenu();
        miCadastroCidade = new javax.swing.JMenuItem();
        miCadastroPais = new javax.swing.JMenuItem();
        miCadastroEstado = new javax.swing.JMenuItem();
        miCadastroEstadoCivil = new javax.swing.JMenuItem();
        miCadastroEndereco = new javax.swing.JMenuItem();
        miCadastroPessoa = new javax.swing.JMenuItem();
        miCadastroHotel = new javax.swing.JMenuItem();
        miCadastroQuarto = new javax.swing.JMenuItem();
        miCadastroReserva = new javax.swing.JMenuItem();
        mnConsulta = new javax.swing.JMenu();
        miConsultaCidade = new javax.swing.JMenuItem();
        miConsultaPais = new javax.swing.JMenuItem();
        miConsultaEstado = new javax.swing.JMenuItem();
        miConsultaEstadoCivil = new javax.swing.JMenuItem();
        miConsultaEndereco = new javax.swing.JMenuItem();
        miConsultaPessoa = new javax.swing.JMenuItem();
        miConsultaHotel = new javax.swing.JMenuItem();
        miConsultaQuarto = new javax.swing.JMenuItem();
        miConsultaReserva = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\n");

        mnCadastro.setText("Cadastros");

        miCadastroCidade.setText("Cidade");
        miCadastroCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroCidadeActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroCidade);

        miCadastroPais.setText("Pais");
        miCadastroPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroPaisActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroPais);

        miCadastroEstado.setText("Estado");
        miCadastroEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroEstadoActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroEstado);

        miCadastroEstadoCivil.setText("EstadoCivil");
        miCadastroEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroEstadoCivilActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroEstadoCivil);

        miCadastroEndereco.setText("Endereço");
        miCadastroEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroEnderecoActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroEndereco);

        miCadastroPessoa.setText("Pessoa");
        miCadastroPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroPessoaActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroPessoa);

        miCadastroHotel.setText("Hotel");
        miCadastroHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroHotelActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroHotel);

        miCadastroQuarto.setText("Quarto");
        miCadastroQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroQuartoActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroQuarto);

        miCadastroReserva.setText("Reserva");
        miCadastroReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroReservaActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroReserva);

        menuBar.add(mnCadastro);

        mnConsulta.setText("Consultas");

        miConsultaCidade.setText("Cidade");
        miConsultaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaCidadeActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaCidade);

        miConsultaPais.setText("Pais");
        miConsultaPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaPaisActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaPais);

        miConsultaEstado.setText("Estado");
        miConsultaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaEstadoActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaEstado);

        miConsultaEstadoCivil.setText("EstadoCivil");
        miConsultaEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaEstadoCivilActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaEstadoCivil);

        miConsultaEndereco.setText("Endereço");
        miConsultaEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaEnderecoActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaEndereco);

        miConsultaPessoa.setText("Pessoa");
        miConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaPessoaActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaPessoa);

        miConsultaHotel.setText("Hotel");
        miConsultaHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaHotelActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaHotel);

        miConsultaQuarto.setText("Quarto");
        miConsultaQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaQuartoActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaQuarto);

        miConsultaReserva.setText("Reserva");
        miConsultaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaReservaActionPerformed(evt);
            }
        });
        mnConsulta.add(miConsultaReserva);

        menuBar.add(mnConsulta);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadastroCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroCidadeActionPerformed
        if (Formularios.cadCidade == null)
            Formularios.cadCidade = new CadCidade();
        
        Formularios.cadCidade.setVisible(true);
    }//GEN-LAST:event_miCadastroCidadeActionPerformed

    private void miConsultaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaCidadeActionPerformed
        if (Formularios.listCidade == null)
            Formularios.listCidade = new ListCidade();
        
        Formularios.listCidade.setVisible(true);
    }//GEN-LAST:event_miConsultaCidadeActionPerformed

    private void miCadastroPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroPaisActionPerformed
        if (Formularios.cadPais == null)
            Formularios.cadPais = new CadPais();
        
        Formularios.cadPais.setVisible(true);
    }//GEN-LAST:event_miCadastroPaisActionPerformed

    private void miConsultaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaPaisActionPerformed
        if (Formularios.listPais == null)
            Formularios.listPais = new ListPais();
        
        Formularios.listPais.setVisible(true);
    }//GEN-LAST:event_miConsultaPaisActionPerformed

    private void miCadastroEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroEstadoActionPerformed
        if (Formularios.cadEstado == null)
            Formularios.cadEstado = new CadEstado();
        
        Formularios.cadEstado.setVisible(true);
    }//GEN-LAST:event_miCadastroEstadoActionPerformed

    private void miConsultaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaEstadoActionPerformed
        if (Formularios.listEstado == null)
            Formularios.listEstado = new ListEstado();
        
        Formularios.listEstado.setVisible(true);
    }//GEN-LAST:event_miConsultaEstadoActionPerformed

    private void miCadastroEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroEnderecoActionPerformed
        if (Formularios.cadEndereco == null)
            Formularios.cadEndereco = new CadEndereco();
        
        Formularios.cadEndereco.setVisible(true);
    }//GEN-LAST:event_miCadastroEnderecoActionPerformed

    private void miConsultaEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaEnderecoActionPerformed
        // TODO add your handling code here:
        if (Formularios.listEndereco == null)
            Formularios.listEndereco = new ListEndereco();
        
        Formularios.listEndereco.setVisible(true);
    }//GEN-LAST:event_miConsultaEnderecoActionPerformed

    private void miCadastroPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroPessoaActionPerformed
        // TODO add your handling code here:
        if (Formularios.cadPessoa == null)
            Formularios.cadPessoa = new CadPessoa();
        
        Formularios.cadPessoa.setVisible(true);
    }//GEN-LAST:event_miCadastroPessoaActionPerformed

    private void miConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaPessoaActionPerformed
        // TODO add your handling code here:
        if (Formularios.listPessoa == null)
            Formularios.listPessoa = new ListPessoa();
        
        Formularios.listPessoa.setVisible(true);
    }//GEN-LAST:event_miConsultaPessoaActionPerformed

    private void miCadastroQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroQuartoActionPerformed
        // TODO add your handling code here:
        if (Formularios.cadQuarto == null)
            Formularios.cadQuarto = new CadQuarto();
        
        Formularios.cadQuarto.setVisible(true);
    }//GEN-LAST:event_miCadastroQuartoActionPerformed

    private void miCadastroEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroEstadoCivilActionPerformed
        // TODO add your handling code here:
        if (Formularios.cadEstadoCivil == null)
            Formularios.cadEstadoCivil = new CadEstadoCivil();
        
        Formularios.cadEstadoCivil.setVisible(true);  
    }//GEN-LAST:event_miCadastroEstadoCivilActionPerformed

    private void miConsultaQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaQuartoActionPerformed
        // TODO add your handling code here:
        if (Formularios.listQuarto == null)
            Formularios.listQuarto = new ListQuarto();
        
        Formularios.listQuarto.setVisible(true);
    }//GEN-LAST:event_miConsultaQuartoActionPerformed

    private void miConsultaEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaEstadoCivilActionPerformed
        // TODO add your handling code here:
        if (Formularios.listEstadoCivil == null)
            Formularios.listEstadoCivil = new ListEstadoCivil();
        
        Formularios.listEstadoCivil.setVisible(true);
    }//GEN-LAST:event_miConsultaEstadoCivilActionPerformed

    private void miCadastroHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroHotelActionPerformed
        // TODO add your handling code here:
        if (Formularios.cadHotel == null)
            Formularios.cadHotel = new CadHotel();
        
        Formularios.cadHotel.setVisible(true);
    }//GEN-LAST:event_miCadastroHotelActionPerformed

    private void miConsultaHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaHotelActionPerformed
        // TODO add your handling code here:
        if (Formularios.listHotel == null)
            Formularios.listHotel = new ListHotel();
        
        Formularios.listHotel.setVisible(true);
    }//GEN-LAST:event_miConsultaHotelActionPerformed

    private void miCadastroReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroReservaActionPerformed
        // TODO add your handling code here:
        if (Formularios.cadReserva == null)
            Formularios.cadReserva = new CadReserva();
        
        Formularios.cadReserva.setVisible(true);
    }//GEN-LAST:event_miCadastroReservaActionPerformed

    private void miConsultaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaReservaActionPerformed
        // TODO add your handling code here:
        if (Formularios.listReserva == null)
            Formularios.listReserva = new ListReserva();
        
        Formularios.listReserva.setVisible(true);
    }//GEN-LAST:event_miConsultaReservaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miCadastroCidade;
    private javax.swing.JMenuItem miCadastroEndereco;
    private javax.swing.JMenuItem miCadastroEstado;
    private javax.swing.JMenuItem miCadastroEstadoCivil;
    private javax.swing.JMenuItem miCadastroHotel;
    private javax.swing.JMenuItem miCadastroPais;
    private javax.swing.JMenuItem miCadastroPessoa;
    private javax.swing.JMenuItem miCadastroQuarto;
    private javax.swing.JMenuItem miCadastroReserva;
    private javax.swing.JMenuItem miConsultaCidade;
    private javax.swing.JMenuItem miConsultaEndereco;
    private javax.swing.JMenuItem miConsultaEstado;
    private javax.swing.JMenuItem miConsultaEstadoCivil;
    private javax.swing.JMenuItem miConsultaHotel;
    private javax.swing.JMenuItem miConsultaPais;
    private javax.swing.JMenuItem miConsultaPessoa;
    private javax.swing.JMenuItem miConsultaQuarto;
    private javax.swing.JMenuItem miConsultaReserva;
    private javax.swing.JMenu mnCadastro;
    private javax.swing.JMenu mnConsulta;
    // End of variables declaration//GEN-END:variables
}
