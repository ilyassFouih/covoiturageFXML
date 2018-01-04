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
    
    public List<String > getAllvilles(){
        List<String> vls = getEntityManager().createQuery("select v.nom from Ville v ").getResultList();
        
//        Villes =findAll();
//        for (int i = 0; i < Villes.size(); i++) {
//            vls.get(i).add(Villes.get(i).getNom());
//        }
        
        return vls;
    }
    
    
}
