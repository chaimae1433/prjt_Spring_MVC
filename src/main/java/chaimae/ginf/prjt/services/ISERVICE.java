/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chaimae.ginf.prjt.services;

import java.util.List;

/**
 *
 * @author hp
 */
public interface ISERVICE<C> {
    public void add(C c);
    public void update(C c);
    public void delete(String cne);
    public List<C> listAll();
    public List<C> nonFil();
    public C listByCne(String cne);
    public List<C> listFromFiliere(String cne);
    
}
