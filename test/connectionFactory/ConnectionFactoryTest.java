/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionFactory;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaofelipelopes
 */
public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
    }

    /**
     * Test of getConnection method, of class ConnectionFactory.
     */
    @Test
    public void testGetConnection() {
        try {
            Connection con = new ConnectionFactory().getConnection();
            System.out.println("Conectou !!!");
        } catch (Exception e) {
            System.out.println("Nao conectou !!!!!!!!");
        }
    }
    
}
