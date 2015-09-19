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
        calculadora.setVeiculo(veiculoTeste);
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
    
}
