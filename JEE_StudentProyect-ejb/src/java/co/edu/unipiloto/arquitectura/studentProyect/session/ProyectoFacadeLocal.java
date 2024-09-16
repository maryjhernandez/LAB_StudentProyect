/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.session;

import co.edu.unipiloto.arquitectura.studentProyect.entity.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 * 
 * @author maria
 */
@Local
public interface ProyectoFacadeLocal {

    // Métodos originales
    void create(Proyecto proyecto);

    void edit(Proyecto proyecto);

    void remove(Proyecto proyecto);

    Proyecto find(Object id);

    List<Proyecto> findAll();

    List<Proyecto> findRange(int[] range);

    int count();

    // Métodos adicionales del segundo código
    boolean addProyect(Proyecto proyecto);

    boolean editProyect(Proyecto proyecto);

    boolean deleteProyect(Integer proyectoid);

    Proyecto getProyect(Integer proyectoid);

    List<Proyecto> getAllProyects();
}
