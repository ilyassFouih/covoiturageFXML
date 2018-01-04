/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CircuitVoyage;
import bean.Conducteur;
import bean.Personne;
import bean.Ville;
import bean.Voyage;
import java.util.Date;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class ConducteurService extends AbstractFacade<Conducteur>{
    
    public ConducteurService() {
        super(Conducteur.class);
    }
    
    public int proposerTrajet(String email,Voyage voyage,Conducteur conducteur){
       
        VoyageService voyageService = new VoyageService();
        voyageService.create(voyage);
        
        Personne personne = new Personne(email);
        
        conducteur.setVoyage(voyage);
        conducteur.setPersonne(personne);
        
        create(conducteur);
        
        
        
        return 1; 
    }
    
}
