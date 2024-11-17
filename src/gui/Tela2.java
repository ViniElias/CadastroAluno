/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.AlunoDAO;
import javax.swing.JOptionPane;
import modelo.Aluno;

/**
 *
 * @author vinic
 */
public class Tela2 extends javax.swing.JFrame {

    /**
     * Creates new form Tela2
     */
    public Tela2() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        campoAluno = new javax.swing.JTextField();
        Excluir = new javax.swing.JButton();
        Pesquisar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CalcularIMC = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(800, 150));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Controle de alunos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insira um CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 16))); // NOI18N

        campoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlunoActionPerformed(evt);
            }
        });

        Excluir.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        Pesquisar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        Pesquisar.setText("Pesquisar");
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });

        Atualizar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Para pesquisar os alunos, digite um nome. ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Para atualizar ou excluir um registro, digite um cpf.");

        CalcularIMC.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        CalcularIMC.setLabel("Calcular IMC");
        CalcularIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularIMCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoAluno)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Pesquisar)
                        .addGap(35, 35, 35)
                        .addComponent(Atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(Excluir)
                        .addGap(35, 35, 35)
                        .addComponent(CalcularIMC)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excluir)
                    .addComponent(Pesquisar)
                    .addComponent(Atualizar)
                    .addComponent(CalcularIMC))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAlunoActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        Aluno aluno = new Aluno(null, null, null, 0, 0);
        aluno.setCpf(campoAluno.getText());
        String alunoStr = campoAluno.getText();
        
        if(alunoStr.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o campo.");
            
        } else if(!alunoStr.matches("\\d+") || alunoStr.length() != 11){
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
            
        } else {
            AlunoDAO dao = new AlunoDAO();
            dao.excluirAluno(aluno);
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed
        Aluno aluno = new Aluno(null, null, null, 0, 0);
        aluno.setNome(campoAluno.getText());
        
        if(campoAluno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o campo.");
        } else if(!campoAluno.getText().matches("[A-Za-zÀ-ÖØ-öø-ÿ\\s]+")){
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        } else {
            AlunoDAO dao = new AlunoDAO();
            dao.pesquisarAluno(aluno);
        }
    }//GEN-LAST:event_PesquisarActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        Aluno aluno = new Aluno(null, null, null, 0, 0);
        aluno.setCpf(campoAluno.getText());
        String alunoStr = campoAluno.getText();
        
        if(alunoStr.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o campo.");
            
        } else if(!alunoStr.matches("\\d+") || alunoStr.length() != 11){
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
            
        } else {
            AlunoDAO dao = new AlunoDAO();
            Aluno alunoEncontrado = dao.buscarAlunoPorCpf(aluno);
        
            if (alunoEncontrado != null) {
                AlunoGUI gui = new AlunoGUI();
                gui.setCampoNome(alunoEncontrado.getNome());
                gui.setCampoData(alunoEncontrado.getDataNasc().toString());
                gui.setCampoPeso(String.valueOf(alunoEncontrado.getPeso()));
                gui.setCampoAltura(String.valueOf(alunoEncontrado.getAltura()));

                gui.setVisible(true);
            }
        }
    }//GEN-LAST:event_AtualizarActionPerformed

    private void CalcularIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularIMCActionPerformed
        String cpf = campoAluno.getText();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo.");
        } else if (!cpf.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(null, "Entrada inválida..");
        } else {
            AlunoDAO dao = new AlunoDAO();
            dao.calcularImc(cpf);
        }
    }//GEN-LAST:event_CalcularIMCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AlunoGUI gui = new AlunoGUI();
        gui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton CalcularIMC;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JTextField campoAluno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
