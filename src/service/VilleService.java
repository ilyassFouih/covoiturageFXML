/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Ville;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
 public class VilleService extends AbstractFacade<Ville>{
    

    public VilleService() {
        super(Ville.class);
    }
    
    public List<Ville > getAllvilles(){
        List<Ville> vls = findAll();
        
//        Villes =findAll();
//        for (int i = 0; i < Villes.size(); i++) {
//            vls.get(i).add(Villes.get(i).getNom());
//        }
        
        return vls;
    }
    public Long getId(String nom){
       
        return  (Long) getEntityManager().createQuery("select v.id "
                + "from Ville v where v.nom like '"+nom+"'").getSingleResult();
        
    }
    
    
    
}
