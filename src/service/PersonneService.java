/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Personne;

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

}
