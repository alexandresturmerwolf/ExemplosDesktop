/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplosdesktop;

/**
 *
 * @author wolfi
 */
import java.sql.*;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cadastro extends javax.swing.JFrame {

    private Database db = null;

    public Cadastro() {
        initComponents();
        db = new Database();
        btRecarregarActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        apDados = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();
        btFechar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btIncluir = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btRecarregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de alienígenas");

        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        apDados.setViewportView(tbDados);

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btIncluir.setText("Incluir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btRecarregar.setText("Recarregar");
        btRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecarregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRecarregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(apDados, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apDados, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btIncluir)
                    .addComponent(btExcluir)
                    .addComponent(btRecarregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecarregarActionPerformed
        try {
            ResultSet rs = db.executaQuery("SELECT id, nome, tipo, altura, cor FROM alienigenas");

            Vector cabecalho = new Vector();

            cabecalho.add("ID");
            cabecalho.add("Nome");
            cabecalho.add("Tipo");
            cabecalho.add("Altura");
            cabecalho.add("Cor");

            Vector linhas = new Vector();
            while (rs.next()) {
                Vector colunas = new Vector();
                colunas.add(rs.getString("id"));
                colunas.add(rs.getString("nome"));
                colunas.add(rs.getString("tipo"));
                colunas.add(rs.getString("altura"));
                colunas.add(rs.getString("cor"));

                linhas.add(new Vector(colunas));
            }

            tbDados.setModel(new DefaultTableModel(linhas, cabecalho));         
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btRecarregarActionPerformed

    private int getID() {
        int id = -1;

        if (tbDados.getSelectedRow() > -1) {

            int coluna = 0;
            for (int i = 0; i < tbDados.getColumnCount(); i++) {
                if (tbDados.getColumnName(i).equals("ID")) {
                    coluna = i;
                    break;
                }
            }

            String c = (String) tbDados.getValueAt(tbDados.getSelectedRow(), coluna);
            try {
                id = Integer.parseInt(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int id = getID();

        if (id > -1) {
            db.executaSQL("DELETE FROM alienigenas WHERE id='" + id + "'");
            btRecarregarActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "ID Inválido!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed

        CadastroManutencao man = new CadastroManutencao(this, true);
        man.setVisible(true); 
        
        // não identifica se deu ok ou cancelar...

        try {
            // ao inves de usar man.xxxx, deveria pegar os dados da entidade
            
            db.executaSQL("INSERT INTO alienigenas(nome, tipo, altura, cor) VALUES ('"
                    + man.nome + "','" // pegar o conteudo
                    + man.tipo + "', '" // direto - variavel publica
                    + man.altura + "', '" // não é uma boa prática
                    + man.cor
                    + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

        btRecarregarActionPerformed(null);

    }//GEN-LAST:event_btIncluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int id = getID();

        if (id > -1) {
            CadastroManutencao man = new CadastroManutencao(this, true);

            try {
                ResultSet rs = db.executaQuery("SELECT id, nome, tipo, altura, cor FROM alienigenas WHERE id = '" + id + "'");
                if (rs.next()) {
                    
                    // usar a instancia da entidade
                    man.preencheValores(
                            rs.getString("nome"),
                            rs.getString("tipo"),
                            rs.getString("altura"),
                            rs.getString("cor")
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            man.setVisible(true);

            
            // verificar se foi ok ou cancelar
            
            try {

                // deveria ter usado a entidade ao inves do man.xxx
                db.executaSQL("UPDATE alienigenas SET "
                        + "nome = '" + man.nome + "', "
                        + "tipo = '" + man.tipo + "', "
                        + "altura = '" + man.altura + "', "
                        + "cor = '" + man.cor + "' "
                        + "WHERE id = '" + id + "'"
                );

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        btRecarregarActionPerformed(null);
    }//GEN-LAST:event_btAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane apDados;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btRecarregar;
    private javax.swing.JTable tbDados;
    // End of variables declaration//GEN-END:variables
}
