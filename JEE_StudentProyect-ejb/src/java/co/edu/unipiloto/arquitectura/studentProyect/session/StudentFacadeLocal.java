/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.session;

import co.edu.unipiloto.arquitectura.studentProyect.entity.Student;
import java.util.List;
import javax.ejb.Local;

/**
 * 
 * @author maria
 */
@Local
public interface StudentFacadeLocal {

    // Métodos originales
    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();

    // Métodos adicionales del segundo código
    boolean addStudent(Student student);

    boolean editStudent(Student student);

    boolean deleteStudent(int codigoEstudiante);

    Student getStudent(int codigoEstudiante);

    List<Student> getAllStudents();
}
