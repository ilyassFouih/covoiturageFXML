/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Avis;
import bean.Personne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class AvisService  extends AbstractFacade<Avis>{
    
    public AvisService() {
        super(Avis.class);
    }
    public String getAvis(int avis){
        String res="";
        if(avis==1)
            res="à eviter";
        else if(avis==2)
            res="Bien";
        else if(avis==3)
            res="tres Bien";
        else if(avis==4)
            res="parfait";
        return res;
    }
    
    public void createAvis(Avis avis){
        PersonneService personneService = new PersonneService();
        Personne personne = personneService.find(avis.getPersonne().getEmail());
        personne.setAvis(personne.getAvis() + 1);
        System.out.println(personne.getAvis());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        personneService.edit(personne);
        create(avis);
        
       
    }
      public List<Integer> listeAvisByPersonne(Personne personne){
        int avisParfait=0;
        int avisTresBien=0;
        int avisBien=0;
        int avisAeviter=0;
        List<Integer> res = new ArrayList();
        List<Avis> lesAvis = getEntityManager()
                .createQuery("select v from Avis v where v.personne.email='"+personne.getEmail()+"'").getResultList();
         for (Avis lesAvi : lesAvis) {
             if(lesAvi.getAvis()==4)
             avisParfait++;
             else if(lesAvi.getAvis()==3)
             avisTresBien++;
             else if(lesAvi.getAvis()==2)
             avisBien++;
             else if(lesAvi.getAvis()==1)
             avisAeviter++;
         }
         res.add(avisParfait);
         res.add(avisTresBien);
         res.add(avisBien);
         res.add(avisAeviter);
          System.out.println(res);
        return res;
        
    }
    
    public float calculeProgresseBar(Personne user,int avisSelectionne){
        int getAvis =0;
        int var =0;
        PersonneService personneService=new PersonneService();
        Personne personne=personneService.find(user.getEmail());
        List<Integer> res = listeAvisByPersonne(personne);
        
        if(personne.getAvis()==0){
            return -2;
        }else{
           getAvis= personne.getAvis();
                if(avisSelectionne==4){
                    var =res.get(0);
                    
                }else if(avisSelectionne==3){
                    var =res.get(1);
                }else if(avisSelectionne==2){
                    var =res.get(2);
                }else if(avisSelectionne==1){
                    var=res.get(3);
                    
                }
                return (float) var/personne.getAvis();
        }
      
    }
}
