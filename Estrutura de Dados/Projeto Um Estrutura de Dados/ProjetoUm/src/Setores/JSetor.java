/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setores;

import Usuario.FilaUsuarios;
import Usuario.JUsuarios;
import Usuario.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class JSetor extends javax.swing.JFrame {

    /**
     * Creates new form JSetor
     */
    DefaultTableModel modelo = new DefaultTableModel();
    
    FilaUsuarios fila;
    String nome_setor;
    SetoresDados dados_arquivo = new SetoresDados();
    JUsuarios juser;
    String ultima_chamada_tempo = "00:05:00";
    Relogio clk;
    
    public JSetor(String nome_setor, JUsuarios juser){
        this.nome_setor = nome_setor;
        Boolean vazio = false;
        this.juser = juser;
        
        initComponents();
        setDefaultCloseOperation(JSetor.DISPOSE_ON_CLOSE);
        setLocationRelativeTo( null );
        
        try {
            fila = dados_arquivo.ler_usuarios(nome_setor);
        } catch (IOException ex) {
            vazio = true;
            //Logger.getLogger(JSetor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelo.addColumn("Matrícula");
        modelo.addColumn("CPF");
        modelo.addColumn("Chamada");
        
        JTableFila.setModel(modelo);
        
        if(!vazio)
        {
            this.preencherTabela();
        }
        hora();
    }
    
    public void preencherTabela()
    {
        modelo = (DefaultTableModel) JTableFila.getModel();
        modelo.setRowCount(0);
        modelo.fireTableDataChanged();
        
        ArrayList<ArrayList<String>> users = fila.toArrayString();

        for(ArrayList<String> s: users)
        {
            modelo.addRow(new Object[]{s.get(0), s.get(1), s.get(2)});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableFila = new javax.swing.JTable();
        btnChamar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblUltimaChamada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableFila.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTableFila);
        if (JTableFila.getColumnModel().getColumnCount() > 0) {
            JTableFila.getColumnModel().getColumn(0).setResizable(false);
            JTableFila.getColumnModel().getColumn(1).setResizable(false);
            JTableFila.getColumnModel().getColumn(2).setResizable(false);
        }

        btnChamar.setText("Chamar");
        btnChamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel1.setText("Horário");

        jLabel2.setText("00:00:00");

        jLabel3.setText("Horário da Ultima Chamada");

        lblUltimaChamada.setText("00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(btnChamar)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(224, 224, 224)
                        .addComponent(lblUltimaChamada)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUltimaChamada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnChamar, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamarActionPerformed
        int linha = -1;
        linha = JTableFila.getSelectedRow();
        
        Usuario chamado = new Usuario();
        
        
        if(linha == -1)
        {
            JOptionPane.showMessageDialog(null, "Linha não selecionada.");
        }
        else
        {
            String matricula = (String) JTableFila.getValueAt(linha, 0);
            String cpf = (String) JTableFila.getValueAt(linha, 1);
            String chamada = (String) JTableFila.getValueAt(linha, 2);
            chamado = new Usuario(matricula, cpf, chamada);
            try {
                dados_arquivo.salvar_chamada(chamado);
            }catch (IOException ex) {
            
            }
        }
        
        lblUltimaChamada.setText(clk.pegar());     
        
        juser.jsetor.tirar_chamado_da_lista(chamado);
        juser.jsetor.set_label_text(ultima_chamada_tempo);
        juser.receber_chamadas();
        
        fila.remover(chamado.getMatricula());
        this.preencherTabela();
        this.salvar_fila();
    }//GEN-LAST:event_btnChamarActionPerformed
    
    public void salvar_fila()
    {
        try {
            dados_arquivo.salvar_fila(fila, nome_setor);
        } catch (IOException ex) {
            Logger.getLogger(JSetor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(JSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JSetor(null, null).setVisible(true);
            }
        });
    }
    
    public void hora()
    {
        clk = new Relogio(jLabel2);
        Thread th = clk;
        th.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableFila;
    private javax.swing.JButton btnChamar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUltimaChamada;
    // End of variables declaration//GEN-END:variables
}
