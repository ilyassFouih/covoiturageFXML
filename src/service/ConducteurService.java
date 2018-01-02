/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Conducteur;
import bean.Personne;
import bean.Ville;
import bean.Voyage;
import java.util.Date;

/**
 *
 * @author IlyassElfouih
 */
public class ConducteurService extends AbstractFacade<Conducteur>{
    
    public ConducteurService() {
        super(Conducteur.class);
    }
    
    public int proposerTrajet(String email,Ville villeDep,Ville villeDarr,Date dateVoyage,int nbrPlaceMax,double prix,String typeVoiture){
        Voyage voyage = new Voyage( villeDep, villeDarr, dateVoyage);
        VoyageService voyageService = new VoyageService();
        voyageService.create(voyage);
        
        Personne personne = new Personne(email);
        
        Conducteur conducteur =new Conducteur(typeVoiture, nbrPlaceMax, prix);
        conducteur.setVoyage(voyage);
        conducteur.setPersonne(personne);
        
        create(conducteur);
        
        
        
        return 1; 
    }
    
}
