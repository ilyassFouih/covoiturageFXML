/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Passager;
import bean.Ville;
import bean.Voyage;
import java.util.Date;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class PassagerService extends AbstractFacade<Passager>{
    
    public PassagerService() {
        super(Passager.class);
    }
    
    public Voyage chercherVoyage(Ville villeDep,Ville villeArr,Date dateVoyage){
        
        String count="select v from Voyage v where 1=1 ";
        
        if(villeDep!=null)
            count+=" and v.villeArriver='"+villeDep+"'";
        if(villeArr!=null)
            count+=" and v.villeDepart='"+villeArr+"'";
        if(dateVoyage!=null)
            count+=" and v.dateVoyage="+dateVoyage+"";
        
        return (Voyage) getEntityManager().createQuery(count).getSingleResult();
        
      
    }
    
    public List<Passager> getPassagerForVoyage(Voyage voyage){
        return getEntityManager().createQuery("select p "
                + "from Passager p where p.voyage.id= '"+voyage.getId()+"'").getResultList();
    } 
    public List<Passager> findByEmail(String email){
        return getEntityManager().createQuery("select p from Passager p where p.personne.email ='"+email+"'")
                .getResultList();
    }
}
    

