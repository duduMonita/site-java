package bean;

import entidades.Paciente;
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
import sessao.PacienteFacade;

@Named(value = "pacienteManagedBean")
@ManagedBean
@SessionScoped
public class PacienteManagedBean implements Serializable {

    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB
    private PacienteFacade pacienteFacade;
    private Paciente paciente;
    private ListDataModel pacientes;
    
    public List<Paciente> lista(){
        return (List<Paciente>) pacientes;
    }
    
    public ListDataModel getPacientes(){
        return this.pacientes;
    }
    
    public void setPacientes(ListDataModel paciente){
        this.pacientes = paciente;
    }
    
    private void recuperarPacientes(){
        this.pacientes = new ListDataModel(pacienteFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarPacientes();
    }
    
    public Paciente getPaciente(){
        if(this.paciente == null){
            this.paciente = new Paciente();
        }
        return paciente;
    }
    
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    
    public String salvar(){
        if(verificaPaciente()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaPaciente(){
        if(this.pacienteFacade.find(this.paciente.getIdPaciente()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.pacienteFacade.create(paciente);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Salvo com Sucesso!"));
        return "listarPaciente";
    }
    
    public String atualizar(){
        this.pacienteFacade.edit(paciente);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/RH" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/paciente/inserirPaciente";
    }
    
    public String montarPaginaListar(){
        return "/Crud/paciente/listarPaciente";
    }
    
    public PacienteManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
    
}
