package bean;

import entidades.Prontuario;
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
import sessao.ProntuarioFacade;

@Named(value = "prontuarioManagedBean")
@ManagedBean
@SessionScoped
public class ProntuarioManagedBean implements Serializable {

    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB
    private ProntuarioFacade prontuarioFacade;
    
    private Prontuario prontuario;
    
    private ListDataModel prontuarios;
    
    public List<Prontuario> lista(){
        return (List<Prontuario>) prontuarios;
    }
    
    public ListDataModel getProntuarios(){
        return this.prontuarios;
    }
    
    public void setProntuarios(ListDataModel prontuarios){
        this.prontuarios = prontuarios;
    }
    
    private void recuperarTodos(){
        this.prontuarios = new ListDataModel(prontuarioFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarTodos();
    }
    
    public Prontuario getProntuario(){
        if(this.prontuario == null){
            this.prontuario = new Prontuario();
        }
        return this.prontuario;
    }
    
    public void setProntuario(Prontuario prontuario){
        this.prontuario = prontuario;
    }
    
    public String salvar(){
        if(verificaProntuario()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaProntuario(){
        if(this.prontuarioFacade.find(this.prontuario.getIdProntuario()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.prontuarioFacade.create(prontuario);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly","Salvo com Sucesso!"));
        return "listarProntuario";
    }
    
    public String atualizar(){
        this.prontuarioFacade.edit(prontuario);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/RH" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/prontuario/inserirProntuario";
    }
    
    public String montarPaginaListar(){
        return "/Crud/prontuario/listarProntuario";
    }
    
    public ProntuarioManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
}
