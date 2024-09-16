package co.edu.unipiloto.arquitectura.studentProyect.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author maria
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Student.findByNombres", query = "SELECT s FROM Student s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Student.findByApellidos", query = "SELECT s FROM Student s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Student.findBySemestre", query = "SELECT s FROM Student s WHERE s.semestre = :semestre"),
    @NamedQuery(name = "Student.findByCorreo", query = "SELECT s FROM Student s WHERE s.correo = :correo")
})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private Integer studentid;
    
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    
    @Column(name = "SEMESTRE")
    private Integer semestre;
    
    @Size(max = 100)
    @Column(name = "CORREO")
    private String correo;

    // Manteniendo las relaciones con Proyecto y Curso del primer código
    @JoinTable(name = "ESTUDIANTE_PROYECT", joinColumns = {
        @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID_PROYECTO")})
    @ManyToMany
    private Collection<Proyecto> proyectoCollection;

    @JoinTable(name = "ESTUDIANTE_CURSO", joinColumns = {
        @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "CODIGO_CURSO")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Curso> cursoCollection;

    // Constructor sin parámetros
    public Student() {
    }

    // Constructor con todos los atributos
    public Student(Integer studentid, String nombres, String apellidos, Integer semestre, String correo, Collection<Proyecto> proyectoCollection, Collection<Curso> cursoCollection) {
        this.studentid = studentid;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.semestre = semestre;
        this.correo = correo;
        this.proyectoCollection = proyectoCollection;
        this.cursoCollection = cursoCollection;
    }

    // Getters y Setters
    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        return this.studentid != null && this.studentid.equals(other.studentid);
    }

    @Override
    public String toString() {
        return "Student{" + "studentid=" + studentid + ", nombres=" + nombres + ", apellidos=" + apellidos + ", semestre=" + semestre + ", correo=" + correo + '}';
    }
}
