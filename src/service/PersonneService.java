/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Personne;
import bean.Voyage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IlyassElfouih
 */
public class PersonneService extends AbstractFacade<Personne> {

    public PersonneService() {
        super(Personne.class);
    }

    public int seConnecter(Personne personne) {
        Personne loader = find(personne.getId());
        if (loader == null) {
            return -1;//l'email n'existe pas 
        } else if (!loader.getPassword().equals(personne.getPassword())) {
            return -2;//le password est incorrecte 
        } else {
            return 1;
        }
    }

    public int sinscrire(Personne personne) {
        if (personne == null) {
            return -1;
        } else {
            create(personne);
            return 1;
        }
    }

    public int modifierProfil(Personne personne, String email) {
        if (personne == null) {
            return -1;
        } else {
            Personne anciennePersonne = find(email);
            if (anciennePersonne == null) {
                return -2;
            } else {
                if(personne.getPrenom()!=null)
                anciennePersonne.setPrenom(personne.getPrenom());
                if(personne.getNom()!=null)
                anciennePersonne.setNom(personne.getNom());
                if(personne.getTel()!=null)
                anciennePersonne.setTel(personne.getTel());
                if(personne.getPassword()!=null)
                anciennePersonne.setPassword(personne.getPassword());
                if(personne.getCin()!=null)
                anciennePersonne.setCin(personne.getCin());
                
                anciennePersonne.setAge(personne.getAge());
              
                
                edit(anciennePersonne);
                return 1;
            }

        }
    }
    
    public List<Personne> getPersonneByVoyage(Voyage voyage)
    {
        List<Personne> personnes = new ArrayList();
        PassagerService passagerService = new PassagerService();
        ConducteurService conducteurService = new ConducteurService();
        personnes= passagerService.getEntityManager()
               .createQuery("select p.personne from Passager p where p.voyage.id = "+voyage.getId()+"")
               .getResultList();
        Personne personne = (Personne) conducteurService.getEntityManager()
                            .createQuery("select c.personne from Conducteur c where c.voyage.id = "+voyage.getId()+"")
                            .getSingleResult();
        personnes.add(personne);
        
        
        return personnes ;
    }

}
