package bean;

import entidades.Alergia;
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
import sessao.AlergiaFacade;

@Named(value = "alergiaManagedBean")
@ManagedBean
@SessionScoped
public class AlergiaManagedBean implements Serializable {
    
    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
            
    @EJB
    private AlergiaFacade arlergiaFacade;
    
    private Alergia alergia;
    private ListDataModel alergias;
    
    public List<Alergia> lista(){
        return (List<Alergia>) alergias;
    }
    
    public ListDataModel getAlergias(){
        return alergias;
    }
    
    public void setAlergias(ListDataModel alergias){
        this.alergias = alergias;
    }
    
    private void recuperarAlergias(){
        this.alergias = new ListDataModel(arlergiaFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarAlergias();
    }
    
    public Alergia getAlergia(){
        if(alergia == null){
            alergia = new Alergia();
        }
        return alergia;
    }
    
    public void setAlergia(Alergia alergia){
        this.alergia = alergia;
    }
    
    public String salvar(){
        if(verificaAlergia()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaAlergia(){
        if(this.arlergiaFacade.find(this.alergia.getIdAlergia()) == null){
            return false;
        } else return true;
    }
    
    public String inserir(){
        this.arlergiaFacade.create(alergia);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Salvo com Sucesso!"));
        return "listarAlergia";
    }
    
    public String atualizar(){
        this.arlergiaFacade.edit(alergia);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/alergia/inserirAlergia";
    }
    
    public String montarPaginaListar(){
        return "/Crud/alergia/listarAlergia";
    }
    
    public AlergiaManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
}
