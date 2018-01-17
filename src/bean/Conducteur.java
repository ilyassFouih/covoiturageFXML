/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author IlyassElfouih
 */
@Entity
public class Conducteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeVoiture;
    private int nbrPlaceMax;
    private double prix;
    private double nbrPlaceOuccuper;
    @ManyToOne
    private Personne personne;
    @ManyToOne
    private Voyage voyage;
   

    public Conducteur() {
    }

    public Conducteur(Long id) {
        this.id = id;
    }

    public Conducteur(String typeVoiture, int nbrPlaceMax, double prix) {
        this.typeVoiture = typeVoiture;
        this.nbrPlaceMax = nbrPlaceMax;
        this.prix = prix;
    }
    
    

    public Conducteur(Long id, String typeVoiture, int nbrPlaceMax, double prix, double nbrPlaceOuccuper) {
        this.id = id;
        this.typeVoiture = typeVoiture;
        this.nbrPlaceMax = nbrPlaceMax;
        this.prix = prix;
        this.nbrPlaceOuccuper = nbrPlaceOuccuper;
    }
    
    
    

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getNbrPlaceOuccuper() {
        return nbrPlaceOuccuper;
    }

    public void setNbrPlaceOuccuper(double nbrPlaceOuccuper) {
        this.nbrPlaceOuccuper = nbrPlaceOuccuper;
    }

   
    
    

    public String getTypeVoiture() {
        return typeVoiture;
    }

    public void setTypeVoiture(String typeVoiture) {
        this.typeVoiture = typeVoiture;
    }

    public int getNbrPlaceMax() {
        return nbrPlaceMax;
    }

    public void setNbrPlaceMax(int nbrPlaceMax) {
        this.nbrPlaceMax = nbrPlaceMax;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conducteur)) {
            return false;
        }
        Conducteur other = (Conducteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conducteur{" + "id=" + id + ", typeVoiture=" + typeVoiture + ", nbrPlaceMax=" + nbrPlaceMax + '}';
    }

   
    
}
