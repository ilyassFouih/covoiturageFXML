/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Conducteur;
import bean.Notification;
import bean.Personne;
import bean.Voyage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class NotificationService extends  AbstractFacade<Notification>{
    
    public NotificationService() {
        super(Notification.class);
    }
    public int nbrDeNotificationNonLu(Personne personne ){
        int nbrNotification =0;
        ConducteurService conducteurService = new ConducteurService();
        List<Notification> notifications = getEntityManager()
                .createQuery("select n from Notification n where n.vu= 0").getResultList();
        for (Notification notification : notifications) {
            if(notification.getQui().equals("p") ){
              Conducteur conducteur =  conducteurService.findConducteurbyVoyage(notification.getVoyage());
                if(conducteur.getPersonne().getId()==personne.getId())
                    nbrNotification++;
            }else if(notification.getQui().equals("c") && notification.getPersonne().getId()==personne.getId())
                nbrNotification++;
        }
        return nbrNotification;
         
    }
    
    public List<Notification> listNotificationNonLu(Personne personne){
         ConducteurService conducteurService = new ConducteurService();
         List<Notification> notificationRes = new ArrayList();
        List<Notification> notifications = getEntityManager()
                .createQuery("select n from Notification n where n.vu= 0").getResultList();
        for (Notification notification : notifications) {
            if(notification.getQui().equals("p") ){
              Conducteur conducteur =  conducteurService.findConducteurbyVoyage(notification.getVoyage());
                if(conducteur.getPersonne().getId()==personne.getId())
                    notificationRes.add(notification);
            }else if(notification.getQui().equals("c") && notification.getPersonne().getId()==personne.getId())
                   notificationRes.add(notification);
        }
        return notificationRes;
    }
    
    public void edditerVu(Notification notification ){
        Notification aEdditer = find(notification.getId());
        aEdditer.setVu(1);
        edit(aEdditer);
        
    }
    
    public List<Voyage> voyagesConfirmationTrajet(String email){
        List<Voyage> voyages = new ArrayList();
        List<Notification> notifications = getEntityManager()
                .createQuery("select n from Notification n ")
                .getResultList();
        for (Notification notification : notifications) {
            if(notification.getVu()==2 && notification.getPersonne().getId()==email)
                voyages.add(notification.getVoyage());
        }
        return voyages;
        
    }
    public void edditerVuPourUnVoyage(Voyage voyage,String email){
         List<Notification> notifications =  getEntityManager()
                .createQuery("select n from Notification n")
                .getResultList();
         Notification nf = new Notification();
         for (Notification notification : notifications) {
             if(notification.getVoyage().getId()==voyage.getId() && notification.getPersonne().getEmail()==email){
                  nf=find(notification.getId());
                  nf.setVu(3);
                  edit(nf);
             }
         }
       
        
    }
   
}
