/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carma.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carma
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByCod", query = "SELECT a FROM Actividad a WHERE a.cod = :cod")
    , @NamedQuery(name = "Actividad.findByNombre", query = "SELECT a FROM Actividad a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actividad.findByFinical", query = "SELECT a FROM Actividad a WHERE a.finical = :finical")
    , @NamedQuery(name = "Actividad.findByFfinal", query = "SELECT a FROM Actividad a WHERE a.ffinal = :ffinal")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finical")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finical;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ffinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ffinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codActividad")
    private Collection<ActividadSeccion> actividadSeccionCollection;

    public Actividad() {
    }

    public Actividad(Integer cod) {
        this.cod = cod;
    }

    public Actividad(Integer cod, String nombre, Date finical, Date ffinal) {
        this.cod = cod;
        this.nombre = nombre;
        this.finical = finical;
        this.ffinal = ffinal;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFinical() {
        return finical;
    }

    public void setFinical(Date finical) {
        this.finical = finical;
    }

    public Date getFfinal() {
        return ffinal;
    }

    public void setFfinal(Date ffinal) {
        this.ffinal = ffinal;
    }

    @XmlTransient
    public Collection<ActividadSeccion> getActividadSeccionCollection() {
        return actividadSeccionCollection;
    }

    public void setActividadSeccionCollection(Collection<ActividadSeccion> actividadSeccionCollection) {
        this.actividadSeccionCollection = actividadSeccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carma.model.Actividad[ cod=" + cod + " ]";
    }
    
}
