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
        if (personne == null) {
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

    public int modifierProfil(Personne personne, String ancienneEmail) {
        if (personne == null) {
            return -1;
        } else {
            Personne anciennePersonne = find(ancienneEmail);
            if (anciennePersonne == null) {
                return -2;
            } else {
                anciennePersonne.setPrenom(personne.getPrenom());
                anciennePersonne.setNom(personne.getNom());
                anciennePersonne.setTel(personne.getTel());
                anciennePersonne.setPassword(personne.getPassword());
                edit(anciennePersonne);
                return 1;
            }

        }
    }

}
