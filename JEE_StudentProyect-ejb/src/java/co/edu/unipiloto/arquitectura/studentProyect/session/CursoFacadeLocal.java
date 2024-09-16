/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.session;

import co.edu.unipiloto.arquitectura.studentProyect.entity.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 * 
 * @author maria
 */
@Local
public interface CursoFacadeLocal {

    // Métodos originales
    void create(Curso curso);

    void edit(Curso curso);

    void remove(Curso curso);

    Curso find(Object id);

    List<Curso> findAll();

    List<Curso> findRange(int[] range);

    int count();

    // Métodos adicionales del segundo código
    boolean addCurso(Curso curso);

    boolean editCurso(Curso curso);

    boolean deleteCurso(Integer codigo);

    Curso getCurso(Integer codigo);

    List<Curso> getAllCursos();
}
