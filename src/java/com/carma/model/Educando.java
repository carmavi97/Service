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
@Table(name = "educando")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educando.findAll", query = "SELECT e FROM Educando e")
    , @NamedQuery(name = "Educando.findByCodMiembro", query = "SELECT e FROM Educando e WHERE e.codMiembro = :codMiembro")
    , @NamedQuery(name = "Educando.findByDniTutor", query = "SELECT e FROM Educando e WHERE e.dniTutor = :dniTutor")})
public class Educando implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_miembro")
    private Integer codMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni_tutor")
    private String dniTutor;
    @JoinColumn(name = "cod_miembro", referencedColumnName = "cod", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Miembro miembro;

    public Educando() {
    }

    public Educando(Integer codMiembro) {
        this.codMiembro = codMiembro;
    }

    public Educando(Integer codMiembro, String dniTutor) {
        this.codMiembro = codMiembro;
        this.dniTutor = dniTutor;
    }

    public Integer getCodMiembro() {
        return codMiembro;
    }

    public void setCodMiembro(Integer codMiembro) {
        this.codMiembro = codMiembro;
    }

    public String getDniTutor() {
        return dniTutor;
    }

    public void setDniTutor(String dniTutor) {
        this.dniTutor = dniTutor;
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
        if (!(object instanceof Educando)) {
            return false;
        }
        Educando other = (Educando) object;
        if ((this.codMiembro == null && other.codMiembro != null) || (this.codMiembro != null && !this.codMiembro.equals(other.codMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carma.model.Educando[ codMiembro=" + codMiembro + " ]";
    }
    
}
