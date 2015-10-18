/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import beans.Calculadora;
import beans.CoeficienteAtrito;
import beans.Veiculo;
import dao.CoeficienteAtritoDAO;
import dao.RespostasDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;

/**
 *
 * @author joaofelipelopes
 */
public class Tela extends javax.swing.JFrame {
    private Veiculo veiculo;
    private Calculadora calculadora;
    private DecimalFormat dfDuasCasas;
    private DecimalFormat dfTresCasas;
    private DecimalFormat dfQuatroCasas;
    
    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        setTitle("Dimênsionamento de sistema de frenagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resposta1.setVisible(false);
        resposta2.setVisible(false);
        resposta3.setVisible(false);
        btnSimular.setVisible(false);
        campoSimulacao.setVisible(false);
        labelSimulacao.setVisible(false);
        desaceleracao.setVisible(false);
        mensagemErro.setVisible(false);
        veiculo = new Veiculo();
        calculadora = new Calculadora();
        btnCalcular.addActionListener(new BotaoCalcular());
        desaceleracao.setVisible(false);
        distancia.setVisible(false);
        coeficienteMelhoria.setVisible(false);
        tempoFrenagem.setVisible(false);
        equacao1.setVisible(false);
        equacao2.setVisible(false);
        dfDuasCasas = new DecimalFormat("0.00");
        dfTresCasas = new DecimalFormat("0.000");
        dfQuatroCasas = new DecimalFormat("0.0000");
        btnSimular.addActionListener(new BotaoSimular());
        btnSalvar.addActionListener(new BotaoSalvar());
        btnNovoCalculo.addActionListener(new BotaoNovoCalculo());
    }
    
/* ----------------------------- BTN CALCULAR ------------------------------- */
    
    class BotaoCalcular implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
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
            calculadora.setVeiculo(veiculo);
            DecimalFormat dfDuasCasas = new DecimalFormat("0.00");
            DecimalFormat dfTresCasas = new DecimalFormat("0.000");
            resposta1.setText("Relação entre os discos : " + dfDuasCasas.format(calculadora.relacaoEntreOsDiscos()));
            resposta2.setText("Raio mínimo do disco dianteiro : " + dfTresCasas.format(calculadora.raioMinimoCorrigido()));
            resposta3.setText("Relação do pedal : " + dfDuasCasas.format(calculadora.relacaoPedal()));
            resposta1.setVisible(true);
            resposta2.setVisible(true);
            resposta3.setVisible(true);
            labelSimulacao.setVisible(true);
            campoSimulacao.setVisible(true);
            btnSimular.setVisible(true);
        }
    }
    
/* --------------------------- BOTAO SIMULAR -------------------------------- */
    
    class BotaoSimular implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            veiculo.setRaioDiscoCorrigido(Double.parseDouble(campoSimulacao.getText().replace(",", ".")));
            desaceleracao.setVisible(true);
            distancia.setVisible(true);
            coeficienteMelhoria.setVisible(true);
            tempoFrenagem.setVisible(true);
            equacao1.setVisible(true);
            equacao2.setVisible(true);
            desaceleracao.setText("Desaceleração : " + dfDuasCasas.format(calculadora.desaceleracaoCorrigida()));
            distancia.setText("Distância : " + dfDuasCasas.format(calculadora.distanciaDeFrenagem()));
            coeficienteMelhoria.setText("Coeficiênte de melhoria : " + dfQuatroCasas.format(calculadora.coeficienteDeMelhoria()));
            tempoFrenagem.setText("Tempo de frenagem : " + dfDuasCasas.format(calculadora.tempoDeFrenagem()));
            equacao1.setText("Deslocamento x Tempo : S = " + dfDuasCasas.format(veiculo.getVelocidadeMaxima()) + "t + (" + dfQuatroCasas.format(calculadora.desaceleracaoCorrigida()) + " * (t ˆ 2)) / 2");
            equacao2.setText("Velocidade x Tempo : (V ˆ 2) = (" + dfDuasCasas.format(veiculo.getVelocidadeMaxima()) + " ˆ 2) + 2 * " + dfQuatroCasas.format(calculadora.desaceleracaoCorrigida()) + " * S");
            
        }
        
    }
    
/* ------------------------------ BOTAO SALVAR ------------------------------ */
    
    class BotaoSalvar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RespostasDAO dao = new RespostasDAO();
            try {
                dao.cadastra(calculadora);
                mensagemErro.setText("Dados salvos");
                mensagemErro.setVisible(true);
                //limparTela();
            } catch (Exception exc) {
                mensagemErro.setText(exc.getMessage());
                mensagemErro.setVisible(true);
            }
        }
    }

/* ------------------------------- BOTAO NOVO CALCULO ----------------------- */
    
    class BotaoNovoCalculo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            limparTela();
        }
    }
    
    private void limparTela(){
        distanciaCGDianteira.setText("");
        distanciaCGTraseiro.setText("");
        distanciaEntreEixos.setText("");
        massaVeiculo.setText("");
        massaPiloto.setText("");
        alturaCGSuperficie.setText("");
        raioPneuDianteiro.setText("");
        raioPneuTraseiro.setText("");
        atritoPastilhaDisco.setText("");
        diametroEmboloDianteiro.setText("");
        diametroEmboloTraseira.setText("");
        raioDiscoDianteiro.setText("");
        raioDiscoTraseiro.setText("");
        numeroEmbolosDianteiro.setText("");
        numeroEmbolosTraseiro.setText("");
        distanciaFrenagem.setText("");
        velocidadeMaxima.setText("");
        diametroEmboloCilindroMestre.setText("");
        desaceleracao.setVisible(false);
        distancia.setVisible(false);
        coeficienteMelhoria.setVisible(false);
        tempoFrenagem.setVisible(false);
        equacao1.setVisible(false);
        equacao2.setVisible(false);
        mensagemErro.setVisible(false);
        resposta1.setVisible(false);
        resposta2.setVisible(false);
        resposta3.setVisible(false);
        labelSimulacao.setVisible(false);
        campoSimulacao.setVisible(false);
        btnSimular.setVisible(false);
        
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
        btnSalvar = new javax.swing.JButton();
        resposta1 = new javax.swing.JLabel();
        resposta2 = new javax.swing.JLabel();
        resposta3 = new javax.swing.JLabel();
        btnNovoCalculo = new javax.swing.JButton();
        labelSimulacao = new javax.swing.JLabel();
        campoSimulacao = new javax.swing.JTextField();
        btnSimular = new javax.swing.JButton();
        desaceleracao = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        atritoPneuSolo = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        diametroEmboloCilindroMestre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        raioDiscoDianteiro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        raioDiscoTraseiro = new javax.swing.JTextField();
        distancia = new javax.swing.JLabel();
        coeficienteMelhoria = new javax.swing.JLabel();
        equacao1 = new javax.swing.JLabel();
        tempoFrenagem = new javax.swing.JLabel();
        equacao2 = new javax.swing.JLabel();

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

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        resposta1.setText("resposta 1");

        resposta2.setText("resposta 2");

        resposta3.setText("resposta 3");

        btnNovoCalculo.setText("Novo cálculo");

        labelSimulacao.setText("Raio do disco corrigido [m] : ");

        btnSimular.setText("Simular");

        desaceleracao.setText("resultado simulacao");

        jLabel17.setText("Coeficiênte de atrito entre o pneu e o solo : ");

        atritoPneuSolo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asfalto", "Pedra brita", "Terra seca", "Terra úmida", "Areia", "Neve" }));

        jLabel18.setText("Diâmetro do êmbolo do cilindro mestre : ");

        jLabel19.setText("Raio do disco diânteiro [m] : ");

        jLabel20.setText("Raio do disco traseiro [m] : ");

        distancia.setText("jLabel21");

        coeficienteMelhoria.setText("jLabel22");

        equacao1.setText("jLabel23");

        tempoFrenagem.setText("jLabel24");

        equacao2.setText("jLabel25");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(numeroEmbolosTraseiro))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(numeroEmbolosDianteiro))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(diametroEmboloCilindroMestre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(velocidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distanciaFrenagem, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(atritoPneuSolo, 0, 238, Short.MAX_VALUE)
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resposta2)
                                    .addComponent(resposta3)
                                    .addComponent(resposta1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCalcular)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNovoCalculo)
                                        .addGap(18, 18, 18)
                                        .addComponent(mensagemErro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelSimulacao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSimular))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(desaceleracao)
                                    .addComponent(equacao2)
                                    .addComponent(btnSalvar)
                                    .addComponent(equacao1)
                                    .addComponent(coeficienteMelhoria)
                                    .addComponent(tempoFrenagem)
                                    .addComponent(distancia))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(distanciaCGDianteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(distanciaFrenagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(distanciaCGTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(velocidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanciaEntreEixos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel17)
                    .addComponent(atritoPneuSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(massaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel18)
                    .addComponent(diametroEmboloCilindroMestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(massaPiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular)
                    .addComponent(btnNovoCalculo)
                    .addComponent(mensagemErro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(alturaCGSuperficie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resposta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(raioPneuDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resposta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(raioPneuTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resposta3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(atritoPastilhaDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSimulacao)
                    .addComponent(campoSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(diametroEmboloDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desaceleracao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diametroEmboloTraseira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tempoFrenagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(raioDiscoDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coeficienteMelhoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(raioDiscoTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(numeroEmbolosDianteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(numeroEmbolosTraseiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(equacao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(equacao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void distanciaEntreEixosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaEntreEixosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaEntreEixosActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

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
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnNovoCalculo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSimular;
    private javax.swing.JTextField campoSimulacao;
    private javax.swing.JLabel coeficienteMelhoria;
    private javax.swing.JLabel desaceleracao;
    private javax.swing.JTextField diametroEmboloCilindroMestre;
    private javax.swing.JTextField diametroEmboloDianteiro;
    private javax.swing.JTextField diametroEmboloTraseira;
    private javax.swing.JLabel distancia;
    private javax.swing.JTextField distanciaCGDianteira;
    private javax.swing.JTextField distanciaCGTraseiro;
    private javax.swing.JTextField distanciaEntreEixos;
    private javax.swing.JTextField distanciaFrenagem;
    private javax.swing.JLabel equacao1;
    private javax.swing.JLabel equacao2;
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
    private javax.swing.JLabel resposta1;
    private javax.swing.JLabel resposta2;
    private javax.swing.JLabel resposta3;
    private javax.swing.JLabel tempoFrenagem;
    private javax.swing.JTextField velocidadeMaxima;
    // End of variables declaration//GEN-END:variables
}
