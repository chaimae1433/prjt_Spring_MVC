/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chaimae.ginf.prjt.repository;

import java.util.ArrayList;
import java.util.List;

import chaimae.ginf.prjt.model.Eleve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */

@Repository
public class EleveRepository implements IREPOSITORY<Eleve>{

    static Session session;
    static Transaction transaction = null;
    
    public EleveRepository() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @Override
    public Eleve findByCne(String cne) {
        try{
            Eleve eleve = (Eleve) session.get(Eleve.class, cne);
            return eleve;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error at findByCne(Eleve) " + e.getMessage());
        }
        return null;     
    }

    @Override
    public List<Eleve> findByFiliere(String code_fil) {
    List<Eleve> eleves = new ArrayList<Eleve>();
    try {
            transaction =session.beginTransaction(); 
	    eleves = session.createQuery(" select e from Eleve e where e.filiere.code_fil = :fil")
                    .setParameter("fil", code_fil).list();
        } 
    catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } 
    return eleves;
    } 
    
    @Override
    public List<Eleve> nonFil(){
        List<Eleve> eleves = new ArrayList<Eleve>();
        try {
            transaction =session.beginTransaction(); 
	    eleves = session.createQuery(" select e from Eleve e where e.Ref_Fil is null").list();
	    transaction.commit();
        } 
    catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } 
    return eleves;
    }
    
    @Override
    public List<Eleve> findAll() {             
    List<Eleve> eleves = null;
    try {
        transaction = session.beginTransaction();
        eleves = session.createQuery("FROM Eleve").list();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } 
    return eleves;
    }
 
    @Override
    public void save(Eleve eleve) {
    transaction = session.beginTransaction();
    try {
    session.save(eleve);
    transaction.commit();} 
    catch (Exception e) {
    transaction.rollback();
    e.printStackTrace();}
    }

    @Override
    public void update(Eleve eleve) {
    transaction = session.beginTransaction();
    try {
    session.update(eleve);
    transaction.commit();} 
    catch (Exception e) {
    transaction.rollback();
    e.printStackTrace();}
    }

    @Override    
    public void delete(String cne) {
    Eleve eleve = (Eleve) session.get(Eleve.class, cne);
    transaction = session.beginTransaction();
    try {
    session.delete(eleve);
    transaction.commit();} 
    catch (Exception e) {
    transaction.rollback();
    e.printStackTrace();}
    }
}
