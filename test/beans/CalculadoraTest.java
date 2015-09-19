/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
        veiculoTeste.setDistanciaCgDianteira(0.55);
        veiculoTeste.setDistanciaEntreEixos(1.55);
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
        assertEquals(8293.91, calculadora.pesoEstaticoDianteira() , 0.001);
    }
    
}
