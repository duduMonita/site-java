/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monita
 */
@Entity
@Table(name = "tb_alergia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alergia.findAll", query = "SELECT a FROM Alergia a")
    , @NamedQuery(name = "Alergia.findByIdAlergia", query = "SELECT a FROM Alergia a WHERE a.idAlergia = :idAlergia")
    , @NamedQuery(name = "Alergia.findByDescrAlergia", query = "SELECT a FROM Alergia a WHERE a.descrAlergia = :descrAlergia")})
public class Alergia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alergia")
    private Integer idAlergia;
    @Size(max = 80)
    @Column(name = "descr_alergia")
    private String descrAlergia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alergia")
    private Collection<PacienteAlergia> pacienteAlergiaCollection;

    public Alergia() {
    }

    public Alergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getDescrAlergia() {
        return descrAlergia;
    }

    public void setDescrAlergia(String descrAlergia) {
        this.descrAlergia = descrAlergia;
    }

    @XmlTransient
    public Collection<PacienteAlergia> getPacienteAlergiaCollection() {
        return pacienteAlergiaCollection;
    }

    public void setPacienteAlergiaCollection(Collection<PacienteAlergia> pacienteAlergiaCollection) {
        this.pacienteAlergiaCollection = pacienteAlergiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlergia != null ? idAlergia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergia)) {
            return false;
        }
        Alergia other = (Alergia) object;
        if ((this.idAlergia == null && other.idAlergia != null) || (this.idAlergia != null && !this.idAlergia.equals(other.idAlergia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alergia[ idAlergia=" + idAlergia + " ]";
    }
    
}
