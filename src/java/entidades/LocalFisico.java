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
@Table(name = "tb_local_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalFisico.findAll", query = "SELECT l FROM LocalFisico l")
    , @NamedQuery(name = "LocalFisico.findByIdLocalFisico", query = "SELECT l FROM LocalFisico l WHERE l.idLocalFisico = :idLocalFisico")
    , @NamedQuery(name = "LocalFisico.findByNmLocalFisico", query = "SELECT l FROM LocalFisico l WHERE l.nmLocalFisico = :nmLocalFisico")})
public class LocalFisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_local_fisico")
    private Integer idLocalFisico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nm_local_fisico")
    private String nmLocalFisico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocalFisico")
    private Collection<Prontuario> prontuarioCollection;

    public LocalFisico() {
    }

    public LocalFisico(Integer idLocalFisico) {
        this.idLocalFisico = idLocalFisico;
    }

    public LocalFisico(Integer idLocalFisico, String nmLocalFisico) {
        this.idLocalFisico = idLocalFisico;
        this.nmLocalFisico = nmLocalFisico;
    }

    public Integer getIdLocalFisico() {
        return idLocalFisico;
    }

    public void setIdLocalFisico(Integer idLocalFisico) {
        this.idLocalFisico = idLocalFisico;
    }

    public String getNmLocalFisico() {
        return nmLocalFisico;
    }

    public void setNmLocalFisico(String nmLocalFisico) {
        this.nmLocalFisico = nmLocalFisico;
    }

    @XmlTransient
    public Collection<Prontuario> getProntuarioCollection() {
        return prontuarioCollection;
    }

    public void setProntuarioCollection(Collection<Prontuario> prontuarioCollection) {
        this.prontuarioCollection = prontuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalFisico != null ? idLocalFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalFisico)) {
            return false;
        }
        LocalFisico other = (LocalFisico) object;
        if ((this.idLocalFisico == null && other.idLocalFisico != null) || (this.idLocalFisico != null && !this.idLocalFisico.equals(other.idLocalFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LocalFisico[ idLocalFisico=" + idLocalFisico + " ]";
    }
    
}
