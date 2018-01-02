/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Ville;
import bean.Voyage;
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
        System.out.println("creerCircuit");
        Ville dep = new Ville();
        dep.setNom("agadir");
        Ville arr = new Ville();
        arr.setNom("marakech");
        Voyage voyage = new Voyage(dep, arr, convert("1234-10-02"));
        Ville ville = dep;
        Ville villeArr = arr;
        int num = 1;
        double prix =12.70;
        CircuitVoyageService instance = new CircuitVoyageService();
        int expResult = 1;
        int result = instance.creerCircuit(voyage, ville, villeArr, num, prix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
