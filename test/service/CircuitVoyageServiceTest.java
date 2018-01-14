/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CircuitVoyage;
import bean.Ville;
import bean.Voyage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static util.DateUtil.convert;

/**
 *
 * @author IlyassElfouih
 */
public class CircuitVoyageServiceTest {
    
    public CircuitVoyageServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of creerCircuit method, of class CircuitVoyageService.
     */
    @Test
    public void testCreerCircuit() {
        VilleService villeService= new VilleService();
        System.out.println("creerCircuit");
        Ville ville1 =villeService.find(new Long("1")); /// dire ville 2 et 3 
        Ville ville2 = villeService.find(new Long("2"));
        Ville ville3 = villeService.find(new Long("3"));
        Ville ville4 = villeService.find(new Long("4"));
        Voyage voyage = new Voyage(ville1,ville2, convert("24-02-2017"));
        List<CircuitVoyage> circuitVoyages = new ArrayList();
        CircuitVoyage circuitVoyage1 = new CircuitVoyage(voyage, ville1, ville2, 1, 100);
        CircuitVoyage circuitVoyage2 = new CircuitVoyage(voyage, ville2, ville3, 2, 100);
        CircuitVoyage circuitVoyage3 = new CircuitVoyage(voyage, ville3, ville4, 1, 100);
        circuitVoyages.add(circuitVoyage1);
        circuitVoyages.add(circuitVoyage2);
        circuitVoyages.add(circuitVoyage3);
        CircuitVoyageService instance = new CircuitVoyageService();
        int expResult = 1;
        int result = instance.creerCircuit(voyage, circuitVoyages);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
