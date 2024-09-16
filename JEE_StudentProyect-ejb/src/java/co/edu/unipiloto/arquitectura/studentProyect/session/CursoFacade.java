/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.session;

import co.edu.unipiloto.arquitectura.studentProyect.entity.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maria
 */
@Stateless
public class CursoFacade extends AbstractFacade<Curso> implements CursoFacadeLocal {

    @PersistenceContext(unitName = "studentProyect-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }

    public boolean addCurso(Curso curso) {
        Curso prexistente = getCurso(curso.getCodigo());
        if (prexistente == null) {
            em.persist(curso);
            return true;
        }
        return false;
    }

    public boolean editCurso(Curso curso) {
        Curso prexistente = getCurso(curso.getCodigo());
        if (prexistente != null) {
            em.merge(curso);
            return true;
        }
        return false;
    }

    public boolean deleteCurso(Integer codigo) {
        Curso prexistente = getCurso(codigo);
        if (prexistente != null) {
            em.remove(prexistente);
            return true;
        }
        return false;
    }

    public Curso getCurso(Integer codigo) {
        return em.find(Curso.class, codigo);
    }

    public List<Curso> getAllCursos() {
        return findAll();
    }
}
