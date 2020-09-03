package bean;

import entidades.Medico;
import entidades.Setores;
import entidades.Usuario;
import java.beans.Transient;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.MedicoFacade;

@Named(value = "medicoManagedBean")
@ManagedBean
@SessionScoped
public class MedicoManagedBean implements Serializable {
    
    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB
    private MedicoFacade medicoFacade;
    
    private Medico medico;
    
    private ListDataModel medicos;
    
    public List<Medico> lista(){
        return (List<Medico>) medicos;
    }
    
    public ListDataModel getMedicos(){
        return this.medicos;
    }
    
    public void setMedicos(ListDataModel medicos){
        this.medicos = medicos;
    }
    
    private void recuperarMedicos(){
        this.medicos = new ListDataModel(medicoFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarMedicos();
    }
    
    public Medico getMedico(){
        if(this.medico == null){
            this.medico = new Medico();
        }
        return medico;
    }
    
    public void setMedico(Medico medico){
        this.medico = medico;
    }
    
    public String salvar(){
        System.out.println("9999");
        if(verificaMedico()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaMedico(){
        if(this.medicoFacade.find(this.medico.getIdMedico()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.medicoFacade.create(medico);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Salvo com Sucesso!"));
        return "listarMedico";
    }
    
    public String atualizar(){
        this.medicoFacade.edit(medico);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){        
        return "/paginas/" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/medico/inserirMedico";
    }
    
    public String montarPaginaListar(){
        return "/Crud/medico/listarMedico";
    }
    
    public MedicoManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
            this.usuarioManagedBean = usuarioManagedBean;
    }
    
}
