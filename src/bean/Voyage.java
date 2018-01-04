/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author IlyassElfouih
 */
@Entity
public class Voyage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Ville villeDepart;
    @ManyToOne
    private Ville villeArriver;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateVoyage ;
    @OneToMany(mappedBy = "voyage")
    private List<Conducteur> conducteurs;
    @OneToMany(mappedBy = "voyage")
    private List<CircuitVoyage> circuitVoyages;
    

    public Voyage() {
    }

    public Voyage(Ville villeDepart, Ville villeArriver, Date dateVoyage) {
        this.villeDepart = villeDepart;
        this.villeArriver = villeArriver;
        this.dateVoyage = dateVoyage;
    }
    
    
    
    

    public Voyage(Long id) {
        this.id = id;
    }

    public Voyage(Long id, Ville villeDepart, Ville villeArriver, Date dateVoyage) {
        this.id = id;
        this.villeDepart = villeDepart;
        this.villeArriver = villeArriver;
       
        this.dateVoyage = dateVoyage;
    }

    public List<Conducteur> getConducteurs() {
        return conducteurs;
    }

    public void setConducteurs(List<Conducteur> conducteurs) {
        this.conducteurs = conducteurs;
    }
    
    

    public Date getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(Date dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    
    public Ville getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    public Ville getVilleArriver() {
        return villeArriver;
    }

    public void setVilleArriver(Ville villeArriver) {
        this.villeArriver = villeArriver;
    }

    public List<CircuitVoyage> getCircuitVoyages() {
        return circuitVoyages;
    }

    public void setCircuitVoyages(List<CircuitVoyage> circuitVoyages) {
        this.circuitVoyages = circuitVoyages;
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
        if (!(object instanceof Voyage)) {
            return false;
        }
        Voyage other = (Voyage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Voyage{" + "id=" + id + ", villeDepart=" + villeDepart + ", villeArriver=" + villeArriver + ", dateVoyage=" + dateVoyage + '}';
    }

  

   
    
}
