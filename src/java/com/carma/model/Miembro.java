/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carma.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carma
 */
@Entity
@Table(name = "miembro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembro.findAll", query = "SELECT m FROM Miembro m")
    , @NamedQuery(name = "Miembro.findByCod", query = "SELECT m FROM Miembro m WHERE m.cod = :cod")
    , @NamedQuery(name = "Miembro.findByNombre", query = "SELECT m FROM Miembro m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Miembro.findByTelefono", query = "SELECT m FROM Miembro m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "Miembro.findByDireccion", query = "SELECT m FROM Miembro m WHERE m.direccion = :direccion")
    , @NamedQuery(name = "Miembro.findByCodSeccion", query = "SELECT m FROM Miembro m WHERE m.codSeccion = :codSeccion")})
public class Miembro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "cod_seccion")
    private Integer codSeccion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "miembro")
    private Educando educando;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "miembro")
    private Monitor monitor;

    public Miembro() {
    }

    public Miembro(Integer cod) {
        this.cod = cod;
    }

    public Miembro(Integer cod, String nombre, int telefono, String direccion) {
        this.cod = cod;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(Integer codSeccion) {
        this.codSeccion = codSeccion;
    }

    public Educando getEducando() {
        return educando;
    }

    public void setEducando(Educando educando) {
        this.educando = educando;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
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
        if (!(object instanceof Miembro)) {
            return false;
        }
        Miembro other = (Miembro) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carma.model.Miembro[ cod=" + cod + " ]";
    }
    
}
