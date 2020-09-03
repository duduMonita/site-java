/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monita
 */
@Entity
@Table(name = "tb_prontuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prontuario.findAll", query = "SELECT p FROM Prontuario p")
    , @NamedQuery(name = "Prontuario.findByIdProntuario", query = "SELECT p FROM Prontuario p WHERE p.idProntuario = :idProntuario")
    , @NamedQuery(name = "Prontuario.findByObservacao", query = "SELECT p FROM Prontuario p WHERE p.observacao = :observacao")
    , @NamedQuery(name = "Prontuario.findBySituacao", query = "SELECT p FROM Prontuario p WHERE p.situacao = :situacao")
    , @NamedQuery(name = "Prontuario.findByDtConsulta", query = "SELECT p FROM Prontuario p WHERE p.dtConsulta = :dtConsulta")
    , @NamedQuery(name = "Prontuario.findByReceita", query = "SELECT p FROM Prontuario p WHERE p.receita = :receita")})
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prontuario")
    private Integer idProntuario;
    @Size(max = 250)
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacao")
    private boolean situacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_consulta")
    @Temporal(TemporalType.DATE)
    private Date dtConsulta;
    @Size(max = 200)
    @Column(name = "receita")
    private String receita;
    @JoinColumn(name = "id_local_fisico", referencedColumnName = "id_local_fisico")
    @ManyToOne(optional = false)
    private LocalFisico idLocalFisico;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    @ManyToOne(optional = false)
    private Medico idMedico;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Paciente idPaciente;

    public Prontuario() {
    }

    public Prontuario(Integer idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Prontuario(Integer idProntuario, boolean situacao, Date dtConsulta) {
        this.idProntuario = idProntuario;
        this.situacao = situacao;
        this.dtConsulta = dtConsulta;
    }

    public Integer getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Integer idProntuario) {
        this.idProntuario = idProntuario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public LocalFisico getIdLocalFisico() {
        return idLocalFisico;
    }

    public void setIdLocalFisico(LocalFisico idLocalFisico) {
        this.idLocalFisico = idLocalFisico;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProntuario != null ? idProntuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prontuario)) {
            return false;
        }
        Prontuario other = (Prontuario) object;
        if ((this.idProntuario == null && other.idProntuario != null) || (this.idProntuario != null && !this.idProntuario.equals(other.idProntuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prontuario[ idProntuario=" + idProntuario + " ]";
    }
    
}
