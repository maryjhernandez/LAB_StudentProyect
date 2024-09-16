/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.studentProyect.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyecto.findByLocalidad", query = "SELECT p FROM Proyecto p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Proyecto.findByPresupuesto", query = "SELECT p FROM Proyecto p WHERE p.presupuesto = :presupuesto"),
    @NamedQuery(name = "Proyecto.findByNumHabitantes", query = "SELECT p FROM Proyecto p WHERE p.numHabitantes = :numHabitantes")
})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROYECTO")
    private Integer idProyecto;

    @Size(max = 100)
    @Column(name = "NOMBRE_PROYECTO")
    private String nombreProyecto;

    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Size(max = 100)
    @Column(name = "LOCALIDAD")
    private String localidad;

    @Column(name = "PRESUPUESTO")
    private BigDecimal presupuesto;

    @Column(name = "NUM_HABITANTES")
    private Integer numHabitantes;

    @ManyToMany(mappedBy = "proyectoCollection")
    private Collection<Student> studentCollection;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String descripcion, String localidad, BigDecimal presupuesto, Integer numHabitantes, Collection<Student> studentCollection) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.numHabitantes = numHabitantes;
        this.studentCollection = studentCollection;
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Integer getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(Integer numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        return (this.idProyecto != null || other.idProyecto == null) && (this.idProyecto == null || this.idProyecto.equals(other.idProyecto));
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.studentProyect.entity.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
}
