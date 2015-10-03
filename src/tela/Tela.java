/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import beans.CoeficienteAtrito;
import beans.Veiculo;
import dao.CoeficienteAtritoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author joaofelipelopes
 */
public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        setTitle("Dimênsionamento de sistema de frenagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        respostaDiametro.setVisible(false);
        respostaRelacaoDisco.setVisible(false);
        respostaTamanhoPedal.setVisible(false);
        botaoSimulacao.setVisible(false);
        campoSimulacao.setVisible(false);
        labelSimulacao.setVisible(false);
        resultadoSimulacao.setVisible(false);
        mensagemErro.setVisible(false);
        btnCalcular.addActionListener(new BotaoCalcular());
    }
    
/* ----------------------------- BTN CALCULAR ------------------------------- */
    
    class BotaoCalcular implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Veiculo veiculo = new Veiculo();
            veiculo.setDistanciaCgDianteira(Double.parseDouble(distanciaCGDianteira.getText().replace(",", ".")));
            veiculo.setDistanciaCgTraseira(Double.parseDouble(distanciaCGTraseiro.getText().replace(",", ".")));
            veiculo.setDistanciaEntreEixos(Double.parseDouble(distanciaEntreEixos.getText().replace(",", ".")));
            veiculo.setMassaVeiculo(Double.parseDouble(massaVeiculo.getText().replace(",", ".")));
            veiculo.setMassaPiloto(Double.parseDouble(massaPiloto.getText().replace(",", ".")));
            veiculo.setAlturaCgEmRelacaoSuperficie(Double.parseDouble(alturaCGSuperficie.getText().replace(",", ".")));
            veiculo.setRaioPneuDianteiro(Double.parseDouble(raioPneuDianteiro.getText().replace(",", ".")));
            veiculo.setRaioPneuTraseiro(Double.parseDouble(raioPneuTraseiro.getText().replace(",", ".")));
            veiculo.setAtritoDisco(Double.parseDouble(atritoPastilhaDisco.getText().replace(",", ".")));
            veiculo.setDiametroEmboloDianteiro(Double.parseDouble(diametroEmboloDianteiro.getText().replace(",", ".")));
            veiculo.setDiametroEmboloTraseiro(Double.parseDouble(diametroEmboloTraseira.getText().replace(",", ".")));
            veiculo.setRaioDiscoDianteiro(Double.parseDouble(raioDiscoDianteiro.getText().replace(",", ".")));
            veiculo.setRaioDiscoTraseiro(Double.parseDouble(raioDiscoTraseiro.getText().replace(",", ".")));
            veiculo.setNumeroEmbolosDianteiro(Integer.parseInt(numeroEmbolosDianteiro.getText().replace(",", ".")));
            veiculo.setNumeroEmbolosTraseiro(Integer.parseInt(numeroEmbolosTraseiro.getText().replace(",", ".")));
            veiculo.setDistanciaFrenagem(Double.parseDouble(distanciaFrenagem.getText().replace(",", ".")));
            veiculo.setVelocidadeMaxima(Double.parseDouble(velocidadeMaxima.getText().replace(",", ".")));
            CoeficienteAtrito coeficiente = new CoeficienteAtrito(atritoPneuSolo.getSelectedItem().toString());
            CoeficienteAtritoDAO dao = new CoeficienteAtritoDAO();
            veiculo.setAtritoSolo(dao.pegaCoeficiente(coeficiente));
            veiculo.setDiametroEmboloCilindroMestre(Double.parseDouble(diametroEmboloCilindroMestre.getText().replace(",", ".")));
            System.out.println(veiculo);
        }
    }
    
/* -------------------------------------------------------------------------- */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        distanciaCGDianteira = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        distanciaCGTraseiro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        distanciaEntreEixos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        massaVeiculo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        massaPiloto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        alturaCGSuperficie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        raioPneuDianteiro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        raioPneuTraseiro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        atritoPastilhaDisco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        diametroEmboloDianteiro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        diametroEmboloTraseira = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        numeroEmbolosDianteiro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        numeroEmbolosTraseiro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        distanciaFrenagem = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        velocidadeMaxima = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        mensagemErro = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        respostaDiametro = new javax.swing.JLabel();
        respostaRelacaoDisco = new javax.swing.JLabel();
        respostaTamanhoPedal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        labelSimulacao = new javax.swing.JLabel();
        campoSimulacao = new javax.swing.JTextField();
        botaoSimulacao = new javax.swing.JButton();
        resultadoSimulacao = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        atritoPneuSolo = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        diametroEmboloCilindroMestre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        raioDiscoDianteiro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        raioDiscoTraseiro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Distância do C.G. para cêntro da rota diánteira [m] :");

        jLabel3.setText("Distância do C.G. para cêntro da roda traseira [m] : ");

        jLabel4.setText("Distância entre eixos [m] : ");

        distanciaEntreEixos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaEntreEixosActionPerformed(evt);
            }
        });

        jLabel5.setText("Massa do veículo [kg] : ");

        jLabel6.setText("Massa do piloto [kg] : ");

        jLabel7.setText("Altura do C.G. em relação a superficie de contato [m] :");

        jLabel8.setText("Raio do pneu diânteiro [m] : ");

        jLabel9.setText("Raio do pneu traseiro [m] : ");

        jLabel10.setText("Coeficiente de atrito da pastilha com o disco : ");

        jLabel11.setText("Diâmetro do êmbolo da pinça diânteira [m] : ");

        jLabel12.setText("Diâmetro do êmbolo da pinça traseira [m] : ");

        jLabel13.setText("Númerro de êmbolos na diânteira : ");

        jLabel14.setText("Número de êmbolos na traseira : ");

        jLabel15.setText("Distância de frenagem [m] : ");

        jLabel16.setText("Velociadde máxima [m/s] : ");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        mensagemErro.setText("Mensagem de erro");

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        respostaDiametro.setText("resposta 1");

        respostaRelacaoDisco.setText("resposta 2");

        respostaTamanhoPedal.setText("resposta 3");

        jButton3.setText("Novo cálculo");

        labelSimulacao.setText("Diâmetro corrigido [m] : ");

        botaoSimulacao.setText("Simular");

        resultadoSimulacao.setText("resultado simulacao");

        jLabel17.setText("Coeficiênte de atrito entre o pneu e o solo : ");

        atritoPneuSolo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asfalto", "Pedra brita", "Terra seca", "Terra úmida", "Areia", "Neve" }));

        jLabel18.setText("Diâmetro do êmbolo do cilindro mestre : ");

        jLabel19.setText("Raio do disco diânteiro [m] : ");

        jLabel20.setText("Raio do disco traseiro [m] : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(distanciaCGTraseiro))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(distanciaCGDianteira, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addGap(18, 18, 18)
                                    .addComponent(raioDiscoTraseiro))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(raioDiscoDianteiro))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(diametroEmboloTraseira))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(diametroEmboloDianteiro))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(atritoPastilhaDisco))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(raioPneuTraseiro))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(raioPneuDianteiro))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(alturaCGSuperficie, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(massaVeiculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                        .addComponent(distanciaEntreEixos, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(massaPiloto)))))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(distanciaFrenagem, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                    .addComponent(velocidadeMaxima)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(atritoPneuSolo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSimulacao)
                                .addGap(18, 18, 18)
                                .addComponent(campoSimulacao))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnCalcular)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(respostaDiametro)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jButton3)
                                                    .addComponent(respostaRelacaoDisco))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mensagemErro)
                                            .addComponent(diametroEmboloCilindroMestre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(respostaTamanhoPedal))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(botaoSimulacao)
                                        .addGap(18, 18, 18)
                                        .addComponent(resultadoSimulacao)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numeroEmbolosDianteiro, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(numeroEmbolosTraseiro))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(distanciaCGDianteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(numeroEmbolosDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(distanciaCGTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(numeroEmbolosTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanciaEntreEixos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(distanciaFrenagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(massaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16)
                    .addComponent(velocidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(massaPiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(atritoPneuSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(alturaCGSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(diametroEmboloCilindroMestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(raioPneuDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(raioPneuTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular)
                    .addComponent(jButton3)
                    .addComponent(mensagemErro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(atritoPastilhaDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(respostaDiametro)
                    .addComponent(respostaRelacaoDisco)
                    .addComponent(respostaTamanhoPedal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(diametroEmboloDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSimulacao)
                    .addComponent(campoSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diametroEmboloTraseira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jButton2)
                    .addComponent(botaoSimulacao)
                    .addComponent(resultadoSimulacao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(raioDiscoDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(raioDiscoTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void distanciaEntreEixosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaEntreEixosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaEntreEixosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alturaCGSuperficie;
    private javax.swing.JTextField atritoPastilhaDisco;
    private javax.swing.JComboBox atritoPneuSolo;
    private javax.swing.JButton botaoSimulacao;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JTextField campoSimulacao;
    private javax.swing.JTextField diametroEmboloCilindroMestre;
    private javax.swing.JTextField diametroEmboloDianteiro;
    private javax.swing.JTextField diametroEmboloTraseira;
    private javax.swing.JTextField distanciaCGDianteira;
    private javax.swing.JTextField distanciaCGTraseiro;
    private javax.swing.JTextField distanciaEntreEixos;
    private javax.swing.JTextField distanciaFrenagem;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelSimulacao;
    private javax.swing.JTextField massaPiloto;
    private javax.swing.JTextField massaVeiculo;
    private javax.swing.JLabel mensagemErro;
    private javax.swing.JTextField numeroEmbolosDianteiro;
    private javax.swing.JTextField numeroEmbolosTraseiro;
    private javax.swing.JTextField raioDiscoDianteiro;
    private javax.swing.JTextField raioDiscoTraseiro;
    private javax.swing.JTextField raioPneuDianteiro;
    private javax.swing.JTextField raioPneuTraseiro;
    private javax.swing.JLabel respostaDiametro;
    private javax.swing.JLabel respostaRelacaoDisco;
    private javax.swing.JLabel respostaTamanhoPedal;
    private javax.swing.JLabel resultadoSimulacao;
    private javax.swing.JTextField velocidadeMaxima;
    // End of variables declaration//GEN-END:variables
}
