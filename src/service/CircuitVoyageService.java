/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CircuitVoyage;
import bean.Ville;
import bean.Voyage;

/**
 *
 * @author IlyassElfouih
 */
public class CircuitVoyageService extends AbstractFacade<CircuitVoyage>{
    
    public CircuitVoyageService() {
        super(CircuitVoyage.class);
    }
     
    public int creerCircuit( Voyage voyage, Ville villeDep, Ville villeArr, int order, double prix){
         
        VoyageService voyageService = new VoyageService();
        voyageService.create(voyage);
        CircuitVoyage circuitVoyage = new CircuitVoyage(voyage,  villeDep,  villeArr,  order,  prix);
        create(circuitVoyage);
     
        return 1;
        
    }
    
}
