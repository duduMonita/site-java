/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monita
 */
@Entity
@Table(name = "tb_paciente_alergia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacienteAlergia.findAll", query = "SELECT p FROM PacienteAlergia p")
    , @NamedQuery(name = "PacienteAlergia.findByIdPaciente", query = "SELECT p FROM PacienteAlergia p WHERE p.pacienteAlergiaPK.idPaciente = :idPaciente")
    , @NamedQuery(name = "PacienteAlergia.findByIdAlergia", query = "SELECT p FROM PacienteAlergia p WHERE p.pacienteAlergiaPK.idAlergia = :idAlergia")
    , @NamedQuery(name = "PacienteAlergia.findByNivelAlergia", query = "SELECT p FROM PacienteAlergia p WHERE p.nivelAlergia = :nivelAlergia")})
public class PacienteAlergia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacienteAlergiaPK pacienteAlergiaPK;
    @Column(name = "nivel_alergia")
    private Integer nivelAlergia;
    @JoinColumn(name = "id_alergia", referencedColumnName = "id_alergia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alergia alergia;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

    public PacienteAlergia() {
    }

    public PacienteAlergia(PacienteAlergiaPK pacienteAlergiaPK) {
        this.pacienteAlergiaPK = pacienteAlergiaPK;
    }

    public PacienteAlergia(int idPaciente, int idAlergia) {
        this.pacienteAlergiaPK = new PacienteAlergiaPK(idPaciente, idAlergia);
    }

    public PacienteAlergiaPK getPacienteAlergiaPK() {
        return pacienteAlergiaPK;
    }

    public void setPacienteAlergiaPK(PacienteAlergiaPK pacienteAlergiaPK) {
        this.pacienteAlergiaPK = pacienteAlergiaPK;
    }

    public Integer getNivelAlergia() {
        return nivelAlergia;
    }

    public void setNivelAlergia(Integer nivelAlergia) {
        this.nivelAlergia = nivelAlergia;
    }

    public Alergia getAlergia() {
        return alergia;
    }

    public void setAlergia(Alergia alergia) {
        this.alergia = alergia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteAlergiaPK != null ? pacienteAlergiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteAlergia)) {
            return false;
        }
        PacienteAlergia other = (PacienteAlergia) object;
        if ((this.pacienteAlergiaPK == null && other.pacienteAlergiaPK != null) || (this.pacienteAlergiaPK != null && !this.pacienteAlergiaPK.equals(other.pacienteAlergiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PacienteAlergia[ pacienteAlergiaPK=" + pacienteAlergiaPK + " ]";
    }
    
}
