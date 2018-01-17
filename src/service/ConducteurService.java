/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Conducteur;
import bean.Personne;
import bean.Voyage;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class ConducteurService extends AbstractFacade<Conducteur>{
    
    public ConducteurService() {
        super(Conducteur.class);
    }
    
    public void proposerTrajet(String email,Voyage voyage,Conducteur conducteur){
       
      
        PersonneService instance = new PersonneService();
        Personne personne = instance.find(email);
        conducteur.setVoyage(voyage);
        conducteur.setPersonne(personne);
        create(conducteur);
        
    }
    
    public List<Conducteur> getConducteurByEmail(String email){
        return getEntityManager().createQuery("select c from Conducteur c where c.personne.email='"+email+"'")
                .getResultList();
    }
    
     public Conducteur findConducteurbyVoyage(Voyage voyage){

        return (Conducteur) getEntityManager().createQuery("SELECT c FROM Conducteur c WHERE c.voyage.id="+voyage.getId()).getSingleResult();
    }
     
     public boolean nbrPlaceMaxAtteinte(Voyage voyage){
         Conducteur conducteur = (Conducteur) getEntityManager()
                 .createQuery("select c from Conducteur c where c.voyage.id="+voyage.getId()+"").getSingleResult();
         if(conducteur.getNbrPlaceMax()==conducteur.getNbrPlaceOuccuper()){
             return true ;
         }else 
             return false;
         
     }
    
}
