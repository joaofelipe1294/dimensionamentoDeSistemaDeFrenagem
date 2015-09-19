/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CoeficienteAtrito;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaofelipelopes
 */
public class CoeficienteAtritoDAOTest {
    
    public CoeficienteAtritoDAOTest() {
    }

    /**
     * Test of pegaCoeficiente method, of class CoeficienteAtritoDAO.
     */
    @Test
    public void testPegaCoeficiente() {
        CoeficienteAtrito teste = new CoeficienteAtrito();
        teste.setTerreno("Terra úmida");
        CoeficienteAtrito coeficienteAtrito = new CoeficienteAtritoDAO().pegaCoeficiente(teste);
        assertEquals(0.550, coeficienteAtrito.getCoeficienteDeAtritoComSolo() , 0.001);
    }
    
}
