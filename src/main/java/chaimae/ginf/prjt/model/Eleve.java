/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chaimae.ginf.prjt.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


/**
 *
 * @author hp
 */

    @Entity
    @Table(name = "eleves")
public class Eleve implements Serializable{
        
    @Id
    @Basic(optional = false)
    @Column(name = "cne")
    private String cne;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "moyenne")
    private Double moyenne;
    
    @ManyToOne
    @JoinColumn(name = "Ref_fil")
    private Filiere Ref_Fil;
    
    // Constructors  
    
    public Eleve() {}
    public Eleve(String cne) {this.cne = cne;}

    public Eleve(String cne, String nom, String prenom, Double moyenne, Filiere refFil) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
        this.Ref_Fil = refFil;
    }
    // ************************* 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cne != null ? cne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.cne == null && other.cne != null) || (this.cne != null && !this.cne.equals(other.cne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Eleve[ cne=" + cne + " ]";
    }
    // Getters and setters

    public String getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public Filiere getRefFil() {
        return Ref_Fil;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public void setRefFil(Filiere refFil) {
        this.Ref_Fil = refFil;
    }
    
}