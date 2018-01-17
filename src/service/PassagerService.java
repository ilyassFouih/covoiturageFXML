/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Conducteur;
import bean.Notification;
import bean.Passager;
import bean.Personne;
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
    
    public void creatPassagerByNotification(Notification notification){
        PersonneService personneService = new PersonneService();
        NotificationService notificationService = new NotificationService();
        VoyageService voyageService =new VoyageService();
        ConducteurService conducteurService = new ConducteurService();
        Passager passager = new Passager() ;
        
        Notification ntfs = notificationService.find(notification.getId());
        Personne personne = personneService.find(notification.getPersonne().getEmail());
        Voyage voyage = voyageService.find(notification.getVoyage().getId());
        Conducteur conducteur =conducteurService.findConducteurbyVoyage(voyage);
        //-----------------modifier nbrPlaceOcuper-------------------
        conducteur.setNbrPlaceOuccuper(conducteur.getNbrPlaceOuccuper()+1);
        conducteurService.edit(conducteur);
       // --------------------setVu---------------------------------------------
        ntfs.setVu(2);
        notificationService.edit(ntfs);
      //  ---------------------------creation du passager-------------------------
        passager.setPersonne(personne);
        passager.setVoyage(voyage);
        create(passager);
        
        
        
        
    }
}
    

