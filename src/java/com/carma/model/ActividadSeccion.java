/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carma.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carma
 */
@Entity
@Table(name = "actividad_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadSeccion.findAll", query = "SELECT a FROM ActividadSeccion a")
    , @NamedQuery(name = "ActividadSeccion.findByCod", query = "SELECT a FROM ActividadSeccion a WHERE a.cod = :cod")})
public class ActividadSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod")
    private Integer cod;
    @JoinColumn(name = "cod_actividad", referencedColumnName = "cod")
    @ManyToOne(optional = false)
    private Actividad codActividad;
    @JoinColumn(name = "cod_seccion", referencedColumnName = "cod")
    @ManyToOne(optional = false)
    private Seccion codSeccion;

    public ActividadSeccion() {
    }

    public ActividadSeccion(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Actividad getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(Actividad codActividad) {
        this.codActividad = codActividad;
    }

    public Seccion getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(Seccion codSeccion) {
        this.codSeccion = codSeccion;
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
        if (!(object instanceof ActividadSeccion)) {
            return false;
        }
        ActividadSeccion other = (ActividadSeccion) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carma.model.ActividadSeccion[ cod=" + cod + " ]";
    }
    
}
