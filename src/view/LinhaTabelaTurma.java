package view;

import DAO.TurmaDAO;
import Model.Turma;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import saep.Main;

public class LinhaTabelaTurma extends javax.swing.JPanel {
    Turma turma = null;
    HomeProfessor frame = null;

    public LinhaTabelaTurma(Turma turma, HomeProfessor frame) {
        this.turma = turma;
        this.frame = frame;
        initComponents();
        this.nome.setText(turma.getNome());
        this.numero.setText(String.valueOf(turma.getNumero()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        nome.setText("Turma dos Filho da Puta");

        numero.setBackground(new java.awt.Color(204, 204, 255));
        numero.setText("00001");

        jButton1.setText("ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(91, 91, 91)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "DESEJA MESMO EXCLUIR TURMA?");

        if (resposta == JOptionPane.YES_OPTION) {
            boolean detetou = TurmaDAO.deletarTurma(this.turma.getNumero());
            if (detetou) {
                JOptionPane.showMessageDialog(null, "Turma deletada com sucesso");
                new HomeProfessor().setVisible(true);
                this.frame.dispose();
                return;
            }
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL DELETAR TURMA, POIS TEM ATIVIDADES RELACIONADAS");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel numero;
    // End of variables declaration//GEN-END:variables
}
