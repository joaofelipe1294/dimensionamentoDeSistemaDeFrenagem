/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CoeficienteAtritoDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author joaofelipelopes
 */
public class CalculadoraTest {
    private Calculadora calculadora;
    private Veiculo veiculoTeste;
    
    @Before
    public void initialize(){
        calculadora = new Calculadora();
        veiculoTeste = new Veiculo();
        veiculoTeste.setMassaVeiculo(230);
        veiculoTeste.setMassaPiloto(70);
        veiculoTeste.setDiametroEmboloDianteiro(0.03);
        veiculoTeste.setDiametroEmboloTraseiro(0.03);
        veiculoTeste.setVelocidadeMaxima(15.3);
        veiculoTeste.setDistanciaFrenagem(12);
        veiculoTeste.setDistanciaCgTraseira(0.55);
        veiculoTeste.setDistanciaEntreEixos(1.55);
        veiculoTeste.setDistanciaCgDianteira(1);
        veiculoTeste.setAlturaCgEmRelacaoSuperficie(0.6);
        veiculoTeste.setAtritoSolo(new CoeficienteAtritoDAO().pegaCoeficiente(new CoeficienteAtrito("Terra úmida")));
        veiculoTeste.setRaioPneuDianteiro(0.28);
        veiculoTeste.setRaioDiscoDianteiro(0.12); 
        veiculoTeste.setAtritoDisco(0.4);
        veiculoTeste.setNumeroEmbolosDianteiro(2);
        veiculoTeste.setRaioPneuTraseiro(0.27);
        veiculoTeste.setRaioDiscoTraseiro(0.18);   
        veiculoTeste.setNumeroEmbolosTraseiro(2);
        veiculoTeste.setDiametroEmboloCilindroMestre(0.0135);
        calculadora.setVeiculo(veiculoTeste);
        veiculoTeste.setRaioDiscoCorrigido(0.16);
    }

    @Test
    public void massaTotalSistema(){
        assertEquals(300, calculadora.massaTotalDoSistema() , 0.001);
    }
    
    @Test
    public void pesoTotalSistema(){
        assertEquals(2943, calculadora.pesoTotalDoSistema() , 0.001);
    }
    
    
    @Test
    public void areaEmboloPincaDianteira(){
        assertEquals(0.000706858, calculadora.areaDoEmboloPincaDianteira() , 0.000000001);
    }
    
    @Test
    public void areaEmboloPincaTraseira(){
        assertEquals(0.000706858, calculadora.areaDoEmboloPincaTraseira() , 0.000000001);
    }
    
    @Test
    public void acelerecaoDoSistemaPelaEquacaoDeTorriecelli(){
        assertEquals(-9.75375, calculadora.acelerecaoDoSistemaPelaEquacaoDeTorriecelli() , 0.00001);
    }
    
    @Test
    public void pesoEstaticoDianteira(){
        assertEquals(1044.29, calculadora.pesoEstaticoDianteira() , 0.001);
    }
    
    @Test
    public void pesoEstaticoTraseira(){
        assertEquals(1898.709677, calculadora.pesoEstaticoTraseira() , 0.000001);
    }
    
    @Test
    public void pesoParaBaixaVelcidadeDianteira(){
        assertEquals(2176.983871, calculadora.pesoBaixaVelocidadeDianteira() , 0.0000001);
    }
    
    @Test
    public void pesoParaBaixaVelocidadeTraseira(){
        assertEquals(766.016129, calculadora.pesoBaixaVelocidadeTraseira() , 0.0000001);
    }
    
    @Test
    public void forcaResultanteRodaDianteira(){
        assertEquals(1197.34, calculadora.forcaResultanteRodaDianteira() , 0.01);
    }
    
    @Test
    public void momentoGeradoPelaForcaDeFrenagemDianteira(){
        assertEquals(335.2555161, calculadora.momentoGeradoPelaForcaDeFrenagemDianteira() , 0.0000001);
    }
    
    @Test
    public void forcaAplicadaDiscoDianteiro(){
        assertEquals(2793.8, calculadora.forcaAplicadaDiscoDianteiro() , 0.1);
    }
    
    @Test
    public void forcaAplicadaPastilhaDianteira(){
        assertEquals(1117.52, calculadora.forcaAplicadaPastilhaDianteira() , 0.01);
    }
    
    @Test
    public void pressaoTransmitidaAoFluidoPelaDianteira(){
        assertEquals(790482.5569, calculadora.pressaoTransmitidaAoFluidoPelaDianteira() , 0.0001);
    }
    
    @Test
    public void forcaResultanteDaRodaTraseira(){
        assertEquals(421.308871, calculadora.forcaResultanteDaRodaTraseira() , 0.000001);
    }
    
    @Test
    public void momentoGeradoPelaForcaDeFrenagemTraseira(){
        assertEquals(113.7533952, calculadora.momentoGeradoPelaForcaDeFrenagemTraseira() , 0.0000001);
    }
    
    @Test
    public void forcaAplicadaDiscoTraseiro(){
        assertEquals(631.961, calculadora.forcaAplicadaDiscoTraseiro() , 0.01);
    }
    
    @Test
    public void forcaAplicadaPastilhaTraseira(){
        assertEquals(252.784 , calculadora.forcaAplicadaPastilhaTraseira() , 0.01);
    }
    
    @Test
    public void pressaoTransmitidaAoFluidoPelaTraseira(){
        assertEquals(178809.03, calculadora.pressaoTransmitidaAoFluidoPelaTraseira() , 0.01);
    }
    
    //novo calculo
    @Test
    public void forcaAplicadaPastilhaFreioCorrida(){
        assertEquals(1117.52, calculadora.forcaAplicadaPastilhaFreioCorrida() , 0.01);
    }
    
    @Test
    public void forcaAplicadaDiscoCorrigido(){
        assertEquals(2793.8, calculadora.forcaAplicadaDiscoCorrigido() , 0.1);
    }
    
    @Test
    public void raioDoDiscoCorrigido(){
        assertEquals(0.041, calculadora.raioDoDiscoCorrigido() , 0.001);
    }
    
    @Test
    public void relacaoEntreOsDiscos(){
        assertEquals(2.93, calculadora.relacaoEntreOsDiscos() , 0.1);
    }
    
    @Test 
    public void raioMinimoCorrigido(){
        assertEquals(0.1473, calculadora.raioMinimoCorrigido() , 0.0001);
    }
    
    @Test
    public void areaDoEmboloCilindroMestre(){
        assertEquals(0.000143, calculadora.areaDoEmboloCilindroMestre() , 0.000001);
    }
    
    @Test
    public void relacaoPedal(){
        assertEquals(3.7561, calculadora.relacaoPedal() , 0.0001);
    }

    @Test
    public void momentoNovoGeradoRoda(){
        assertEquals(447.008 , calculadora.momentoNovoGeradoRoda(), 0.001);
    }
    
    @Test
    public void forcaResultanteNova(){
        assertEquals(1596.4, calculadora.forcaResultanteNova() , 0.1);
    }
    
    @Test
    public void pesoDinamicoDianteira(){
        assertEquals(2902.65, calculadora.pesoDinamicoDianteira() , 0.01);
    }
    
    @Test
    public void desaceleracaoCorrigida(){
        assertEquals(-16.0025, calculadora.desaceleracaoCorrigida() , 0.0001);
    }
    
    @Test
    public void distanciaDeFrenagem(){
        assertEquals(7.31, calculadora.distanciaDeFrenagem() , 0.01);
    }
    
    @Test
    public void coeficienteDeMelhoria(){
        assertEquals(0.3904, calculadora.coeficienteDeMelhoria() , 0.0001);
    }
    
    @Test
    public void tempoDeFrenagem(){
        assertEquals(0.9561, calculadora.tempoDeFrenagem() , 0.0001);
    }
}
