/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CircuitVoyage;
import bean.Ville;
import bean.Voyage;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class CircuitVoyageService extends AbstractFacade<CircuitVoyage>{
    
    public CircuitVoyageService() {
        super(CircuitVoyage.class);
    }
     
    public int creerCircuit( Voyage voyage, List<CircuitVoyage> circuitVoyages){
         
        VoyageService voyageService = new VoyageService();
//               voyage.setId(voyageService.generateId("Voyage", "id"));
        voyageService.create(voyage);
        System.out.println(voyage);
        for (CircuitVoyage circuitVoyage : circuitVoyages) {
              circuitVoyage.setVoyage(voyage);
              create(circuitVoyage);
              System.out.println(circuitVoyage);
     
        }
      
        return 1;
        
    }
    
}
