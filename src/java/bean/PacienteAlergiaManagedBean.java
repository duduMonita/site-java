package bean;

import entidades.PacienteAlergia;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import sessao.PacienteAlergiaFacade;

@Named(value = "pacienteAlergiaManagedBean")
@ManagedBean
@SessionScoped
public class PacienteAlergiaManagedBean {

    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB
    private PacienteAlergiaFacade pacienteAlergiaFacade;
    private PacienteAlergia pacienteAlergia;
    private ListDataModel pacienteAlergias;
    
    public List<PacienteAlergia> lista(){
        return (List<PacienteAlergia>) pacienteAlergias;
    }
    
    public ListDataModel getPacienteAlergias(){
        return this.pacienteAlergias;
    }
    
    public void setPacienteAlergias(ListDataModel pacienteAlergias){
        this.pacienteAlergias = pacienteAlergias;
    }
    
    private void recuperarPacienteAlergias(){
        this.pacienteAlergias = new ListDataModel(pacienteAlergiaFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarPacienteAlergias();
    }
    
    public PacienteAlergia getPacienteAlergia(){
        if(this.pacienteAlergia == null){
            this.pacienteAlergia = new PacienteAlergia();
        }
        return pacienteAlergia;
    }
    
    public void setPacienteAlergia(PacienteAlergia pacienteAlergia){
        this.pacienteAlergia = pacienteAlergia;
    }
    
    public String salvar(){
        if(verificaPacienteAlergia()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaPacienteAlergia(){
        if(this.pacienteAlergiaFacade.find(this.pacienteAlergia.getAlergia()) == null || this.pacienteAlergiaFacade.find(this.pacienteAlergia.getPaciente()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.pacienteAlergiaFacade.create(pacienteAlergia);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Salvo com Sucesso!"));
        return "listarPacienteAlergia";
    }
    
    public String atualizar(){
        this.pacienteAlergiaFacade.edit(pacienteAlergia);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/RH" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/pacienteAlergia/inserirPacienteAlergia";
    }
    
    public String montarPaginaListar(){
        return "/Crud/pacienteAlergia/listarPacienteAlergia";
    }
    
    public PacienteAlergiaManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
}
