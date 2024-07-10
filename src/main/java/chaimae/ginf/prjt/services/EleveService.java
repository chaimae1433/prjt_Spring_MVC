/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chaimae.ginf.prjt.services;

import chaimae.ginf.prjt.model.Eleve;
import chaimae.ginf.prjt.model.Filiere;
import chaimae.ginf.prjt.repository.EleveRepository;
import chaimae.ginf.prjt.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author hp
 */

@Service
public class EleveService implements ISERVICE<Eleve> {

    @Autowired
    private EleveRepository eleveRepository;
    @Autowired
    private FiliereRepository filiereRepository;

    public EleveRepository getEleveRepository() {
        return eleveRepository;
    }

    public void setEleveRepository(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    public FiliereRepository getFiliereRepository() {
        return filiereRepository;
    }

    public void setFiliereRepository(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    @Override
    public void add(Eleve eleve) {
        eleveRepository.save(eleve);
    }
    @Override
    public void update(Eleve eleve) {
        eleveRepository.update(eleve);
    }
    @Override
    public void delete(String cne) {
        eleveRepository.delete(cne);
    }    
    @Override
    public List<Eleve> listAll() {
        return eleveRepository.findAll();
    }
    @Override
    public Eleve listByCne(String cne) {
        return eleveRepository.findByCne(cne);
    }
    
    @Override
    public List<Eleve> listFromFiliere(String cne) {
        return eleveRepository.findByFiliere(cne);
    }
    
    @Override
    public List<Eleve> nonFil() {
        return eleveRepository.nonFil();
    }
    // ********************************************************************************//
    public void registerStudent(Eleve eleve, String refFiliere) {
        Filiere filiere = filiereRepository.findByCne(refFiliere);
        eleve.setRefFil(filiere);
        eleveRepository.save(eleve);
    }

    public void reassignStudent(Eleve eleve, String refFiliere) {
        Filiere filiere = filiereRepository.findByCne(refFiliere);
        eleve.setRefFil(filiere);
        eleveRepository.save(eleve);
    }

}