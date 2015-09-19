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
    }

    @Test
    public void massaTotalSistema(){
        assertEquals(300, calculadora.massaTotalDoSistema(veiculoTeste) , 0.001);
    }
    
    
}