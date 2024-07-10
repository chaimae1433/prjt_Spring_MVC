/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chaimae.ginf.prjt.services;

import java.util.List;

import chaimae.ginf.prjt.model.Eleve;
import chaimae.ginf.prjt.model.Filiere;
import chaimae.ginf.prjt.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author hp
 */
// FiliereService.java
@Service
public class FiliereService implements ISERVICE<Filiere> {

    @Autowired
    private FiliereRepository filiereRepository;
    
    @Override
    public Filiere listByCne(String cne) {
        return filiereRepository.findByCne(cne);
    }
    @Override
    public List<Filiere> listAll() {
        return filiereRepository.findAll();
    }
    @Override
    public void add(Filiere filiere) {
        filiereRepository.save(filiere);
    }
    @Override
    public void update(Filiere filiere) {
        filiereRepository.update(filiere);
    }
    @Override
    public void delete(String cne) {
        filiereRepository.delete(cne);
    }
    @Override
    public List<Filiere> listFromFiliere(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public List<Filiere> nonFil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // ********************************************************************************//
    public int countEnrolledStudents(String codeFiliere) throws FiliereNotFoundException {
        Filiere filiere = listByCne(codeFiliere);
        if (filiere == null) {
            throw new FiliereNotFoundException();
        }
        return filiere.getEleves().size();
    }
    public List<Eleve> listEnrolledStudents(String codeFiliere) throws FiliereNotFoundException {
    Filiere filiere = listByCne(codeFiliere);
    if (filiere == null) {
        throw new FiliereNotFoundException();
    }
    return filiere.getEleves();
    }

    public static class FiliereNotFoundException extends RuntimeException {
    public FiliereNotFoundException() {
        super("Filiere not found");
    }
    public FiliereNotFoundException(String message) {
        super(message);
    }

    }
}