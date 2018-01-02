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
            count+=" and v.villeArriver='"+villeArr+"'";
        if(villeArr!=null)
            count+=" and v.villeDepart='"+villeDep+"'";
        if(dateVoyage!=null)
            count+=" and v.dateVoyage="+dateVoyage+"";
        
        return (Voyage) getEntityManager().createQuery(count).getSingleResult();
        
      
    }
    
}
    

