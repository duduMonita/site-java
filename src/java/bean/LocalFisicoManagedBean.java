package bean;

import entidades.LocalFisico;
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
import sessao.LocalFisicoFacade;

@Named(value = "localFisicoManagedBean")
@ManagedBean
@SessionScoped
public class LocalFisicoManagedBean implements Serializable {

    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB
    private LocalFisicoFacade localFisicoFacade;
    private LocalFisico localFisico;
    private ListDataModel localFisicos;
    
    public List<LocalFisico> lista(){
        return (List<LocalFisico>) localFisicos;
    }
    
    public ListDataModel getLocalFisicos(){
        return localFisicos;
    }
    
    public void setLocalFisicos(ListDataModel localFisicos){
        this.localFisicos = localFisicos;
    }
    
    private void recuperarLocalFisicos(){
        this.localFisicos = new ListDataModel(localFisicoFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarLocalFisicos();
    }
    
    public LocalFisico getLocalFisico(){
        if(localFisico == null){
            localFisico = new LocalFisico();
        }
        return localFisico;
    }
    
    public void setLocalFisico(LocalFisico localFisico){
        this.localFisico = localFisico;
    }
    
    public String salvar(){
        if(verificaLocalFisico()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaLocalFisico(){  
        if(this.localFisicoFacade.find(this.localFisico.getIdLocalFisico()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.localFisicoFacade.create(localFisico);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Salvo com Sucesso!"));
        return "listarLocalFisico";
    }
    
    public String atualizar(){
        this.localFisicoFacade.edit(localFisico);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/localFisico/inserirLocalFisico";
    }
    
    public String montarPaginaListar(){
        return "/Crud/localFisico/listarLocalFisico";
    }

    public LocalFisicoManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
}
