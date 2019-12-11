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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m")
    , @NamedQuery(name = "Monitor.findByCodMiembro", query = "SELECT m FROM Monitor m WHERE m.codMiembro = :codMiembro")
    , @NamedQuery(name = "Monitor.findByDni", query = "SELECT m FROM Monitor m WHERE m.dni = :dni")})
public class Monitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_miembro")
    private Integer codMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni")
    private String dni;
    @JoinColumn(name = "cod_miembro", referencedColumnName = "cod", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Miembro miembro;

    public Monitor() {
    }

    public Monitor(Integer codMiembro) {
        this.codMiembro = codMiembro;
    }

    public Monitor(Integer codMiembro, String dni) {
        this.codMiembro = codMiembro;
        this.dni = dni;
    }

    public Integer getCodMiembro() {
        return codMiembro;
    }

    public void setCodMiembro(Integer codMiembro) {
        this.codMiembro = codMiembro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMiembro != null ? codMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.codMiembro == null && other.codMiembro != null) || (this.codMiembro != null && !this.codMiembro.equals(other.codMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carma.model.Monitor[ codMiembro=" + codMiembro + " ]";
    }
    
}
