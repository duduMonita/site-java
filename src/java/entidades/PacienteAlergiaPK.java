/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Monita
 */
@Embeddable
public class PacienteAlergiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paciente")
    private int idPaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alergia")
    private int idAlergia;

    public PacienteAlergiaPK() {
    }

    public PacienteAlergiaPK(int idPaciente, int idAlergia) {
        this.idPaciente = idPaciente;
        this.idAlergia = idAlergia;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPaciente;
        hash += (int) idAlergia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteAlergiaPK)) {
            return false;
        }
        PacienteAlergiaPK other = (PacienteAlergiaPK) object;
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        if (this.idAlergia != other.idAlergia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PacienteAlergiaPK[ idPaciente=" + idPaciente + ", idAlergia=" + idAlergia + " ]";
    }
    
}
