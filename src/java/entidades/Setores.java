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
@Table(name = "tb_setores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setores.findAll", query = "SELECT s FROM Setores s")
    , @NamedQuery(name = "Setores.findByIdSetor", query = "SELECT s FROM Setores s WHERE s.idSetor = :idSetor")
    , @NamedQuery(name = "Setores.findByNmSetor", query = "SELECT s FROM Setores s WHERE s.nmSetor = :nmSetor")})
public class Setores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_setor")
    private Integer idSetor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nm_setor")
    private String nmSetor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSetor")
    private Collection<Usuario> usuarioCollection;

    public Setores() {
    }

    public Setores(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Setores(Integer idSetor, String nmSetor) {
        this.idSetor = idSetor;
        this.nmSetor = nmSetor;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNmSetor() {
        return nmSetor;
    }

    public void setNmSetor(String nmSetor) {
        this.nmSetor = nmSetor;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSetor != null ? idSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setores)) {
            return false;
        }
        Setores other = (Setores) object;
        if ((this.idSetor == null && other.idSetor != null) || (this.idSetor != null && !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Setores[ idSetor=" + idSetor + " ]";
    }
    
}
