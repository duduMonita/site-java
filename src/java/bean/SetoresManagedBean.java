package bean;

import entidades.Setores;
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
import sessao.SetoresFacade;

@Named(value = "setoresManagedBean")
@ManagedBean
@SessionScoped
public class SetoresManagedBean implements Serializable {

    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB    
    private SetoresFacade setorFacade;
    
    private Setores setor;
    
    private ListDataModel setores;
    
    public List<Setores> lista(){
        return (List<Setores>) setores;
    }
    
    public ListDataModel getSetores(){
        return this.setores;
    }
    
    public void setSetores(ListDataModel setores){
        this.setores = setores;
    }
    
    private void recuperarTodos(){
        this.setores = new ListDataModel(setorFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarTodos();
    }
    
    public Setores getSetor(){
        if(this.setor == null){
            this.setor = new Setores();
        }
        return this.setor;
    }
    
    public void setSetor(Setores setor){
        this.setor = setor;
    }

    public String salvar(){
        if(verificaSetor()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaSetor(){
        if(this.setorFacade.find(this.setor.getIdSetor()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.setorFacade.create(setor);
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Succesfuly","Salvo com Sucesso!"));
        return null;
    }
    
    public String atualizar(){
        this.setorFacade.edit(setor);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/setor/inserirSetor";
    }
    
    public String montarPaginaListar(){
        return "/Crud/setor/listarSetor";
    }
    
    public SetoresManagedBean() {
    }  
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
}
