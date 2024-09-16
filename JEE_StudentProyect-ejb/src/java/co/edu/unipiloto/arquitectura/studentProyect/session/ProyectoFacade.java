/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.session;

import co.edu.unipiloto.arquitectura.studentProyect.entity.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maria
 */
@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> implements ProyectoFacadeLocal {

    @PersistenceContext(unitName = "studentProyect-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }

    // Métodos adicionales del segundo código:

    public boolean addProyect(Proyecto proyecto) {
        Proyecto prexistente = getProyect(proyecto.getIdProyecto());
        if (prexistente == null) {
            em.persist(proyecto);
            return true;
        }
        return false;
    }


    public boolean editProyect(Proyecto proyecto) {
        Proyecto prexistente = getProyect(proyecto.getIdProyecto());
        if (prexistente != null) {
            em.merge(proyecto);
            return true;
        }
        return false;
    }

 
    public boolean deleteProyect(Integer idProyecto) {
        Proyecto prexistente = getProyect(idProyecto);
        if (prexistente != null) {
            em.remove(prexistente);
            return true;
        }
        return false;
    }


    public Proyecto getProyect(Integer idProyecto) {
        return em.find(Proyecto.class, idProyecto);
    }


    public List<Proyecto> getAllProyects() {
        return findAll();
    }
}
