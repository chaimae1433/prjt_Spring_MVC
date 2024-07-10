/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chaimae.ginf.prjt.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author hp
 */
    @Entity
    @Table(name = "filieres")
public class Filiere implements Serializable {
        
    @Id
    @Basic(optional = false)
    @Column(name = "code_fil")
    private String code_fil;
    
    @Column(name = "nom_fil")
    private String nom_fil;
    
    @OneToMany(mappedBy = "Ref_Fil", cascade = CascadeType.ALL)
    private List<Eleve> eleves;

    public List<Eleve> getEleves() {
    return eleves;
    }
    
    public Filiere() {
    }

    public Filiere(String code_fil, String nom_fil) {
        this.code_fil = code_fil;
        this.nom_fil = nom_fil;
    }
    

    public Filiere(String codeFil) {
        this.code_fil = codeFil;
    }
    
     // Getters and setters

    public String getCode_fil() {
        return code_fil;
    }

    public String getNom_fil() {
        return nom_fil;
    }

    public void setCode_fil(String code_fil) {
        this.code_fil = code_fil;
    }

    public void setNom_fil(String nom_fil) {
        this.nom_fil = nom_fil;
    }

}