/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CircuitVoyage;
import bean.Ville;
import bean.Voyage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class VoyageService  extends AbstractFacade<Voyage>{
    
    public VoyageService() {
        super(Voyage.class);
    }
    
    
     public List<Voyage> chercherVoyage(Ville villeDep, Ville villeArr, String dateVoyage) {
           ConducteurService conducteurService = new ConducteurService();
        List<Voyage> voyages = new ArrayList();
        List<Voyage> res = new ArrayList();

        if (dateVoyage != null) {
        voyages = getEntityManager().createQuery("SELECT v from Voyage v where v.dateVoyage='" + dateVoyage+"'").getResultList();
        } else {
            return null;
        }
//        


        for (Voyage voyage : voyages) {
            List<CircuitVoyage> circuitVoyages = voyage.getCircuitVoyages();
          boolean var=  conducteurService.nbrPlaceMaxAtteinte(voyage);
            if (voyage.getVilleArriver().equals(villeArr) && voyage.getVilleDepart().equals(villeDep) && !var) {
                res.add(voyage);
              
            } else {
                for (CircuitVoyage circuitVoyage : circuitVoyages) {
                    if (circuitVoyage.getVilleArr().equals(villeArr) && circuitVoyage.getVilleDep().equals(villeDep)) {
                        res.add(voyage);
                    }

                }
            }
        }
        return res;
    }
}
