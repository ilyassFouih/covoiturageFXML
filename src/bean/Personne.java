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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author IlyassElfouih
 */
@Entity
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String email;
    private String nom ;
    private String prenom ;
    private String password ;
    private String tel ;
    private boolean fumeur ;
    private int age ;
    private String cin;
    private int avis;
    private boolean Conducteur;
    private int nbrVoyageTotale;
    private int nbrVoyageConducteur;
    private int nbrVoyagePassager;
    @OneToMany(mappedBy = "personne")
    private List<Conducteur> conducteurs;
    @OneToMany(mappedBy = "personne")
    private List<Avis> aviss;

    public Personne(String email, String nom, String prenom, String password, String tel) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.tel = tel;
        
    }

    public Personne(String nom, String prenom, String password, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.tel = tel;
    }
    
    
    

    public Personne(String email, String nom, String prenom, String password, String tel, boolean fumeur,  String cin, int avis, boolean Conducteur, int nbrVoyageTotale, int nbrVoyageConducteur, int nbrVoyagePassager) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.tel = tel;
        this.fumeur = fumeur;
        
        this.cin = cin;
        this.avis = avis;
        this.Conducteur = Conducteur;
        this.nbrVoyageTotale = nbrVoyageTotale;
        this.nbrVoyageConducteur = nbrVoyageConducteur;
        this.nbrVoyagePassager = nbrVoyagePassager;
    }

    public Personne(String email) {
        this.email = email;
    }

    public Personne() {
    }

    public Personne(String nom, String prenom, String password, String tel, boolean fumeur, int age, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.tel = tel;
        this.fumeur = fumeur;
        this.age = age;
        this.cin = cin;
    }


    public boolean isConducteur() {
        return Conducteur;
    }

    public void setConducteur(boolean isConducteur) {
        this.Conducteur = isConducteur;
    }

    public int getNbrVoyageTotale() {
        return nbrVoyageTotale;
    }

    public void setNbrVoyageTotale(int nbrVoyageTotale) {
        this.nbrVoyageTotale = nbrVoyageTotale;
    }

    public int getNbrVoyageConducteur() {
        return nbrVoyageConducteur;
    }

    public void setNbrVoyageConducteur(int nbrVoyageConducteur) {
        this.nbrVoyageConducteur = nbrVoyageConducteur;
    }

    public int getNbrVoyagePassager() {
        return nbrVoyagePassager;
    }

    public void setNbrVoyagePassager(int nbrVoyagePassager) {
        this.nbrVoyagePassager = nbrVoyagePassager;
    }

    
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    public boolean isFumeur() {
        return fumeur;
    }

    public void setFumeur(boolean fumeur) {
        this.fumeur = fumeur;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   

    public String getCin() {
        return cin;
    }

    public void setCin(String Cin) {
        this.cin = Cin;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
    }

    
   
    
    
    
    

    public String getId() {
        return email;
    }

    public void setId(String id) {
        this.email = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne{" + "email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", tel=" + tel + ", fumeur=" + fumeur + ", age=" + age + ", cin=" + cin + ", avis=" + avis + ", Conducteur=" + Conducteur + ", nbrVoyageTotale=" + nbrVoyageTotale + ", nbrVoyageConducteur=" + nbrVoyageConducteur + ", nbrVoyagePassager=" + nbrVoyagePassager + '}';
    }

  

  


    
}
