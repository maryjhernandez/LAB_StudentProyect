/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.session;

import co.edu.unipiloto.arquitectura.studentProyect.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author maria
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "studentProyect-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    // Método para agregar un estudiante
    
    public boolean addStudent(Student student) {
        Student prexistent = getStudent(student.getStudentid());
        if (prexistent == null) {
            em.persist(student);
            return true;
        }
        return false;
    }

    // Método para editar un estudiante
    
    public boolean editStudent(Student student) {
        Student prexistent = getStudent(student.getStudentid());
        if (prexistent != null) {
            em.merge(student);
            return true;
        }
        return false;
    }

    // Método para eliminar un estudiante
    
    public boolean deleteStudent(int codigoEstudiante) {
        Student estudiante = getStudent(codigoEstudiante);
        if (estudiante != null) {
            em.remove(estudiante);
            return true;
        }
        return false;
    }

    // Método para obtener un estudiante por su ID
    
    public Student getStudent(int codigoEstudiante) {
        return em.find(Student.class, codigoEstudiante);
    }

    // Método para obtener todos los estudiantes
   
    public List<Student> getAllStudents() {
        return findAll();
    }
}

