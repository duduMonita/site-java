package bean;

import entidades.Usuario;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.SetoresFacade;
import sessao.UsuarioFacade;

@Named(value = "usuarioManagedBean")
@ManagedBean
@SessionScoped
public class UsuarioManagedBean implements Serializable {

    @EJB
    private SetoresFacade setorFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private Usuario usuario;
    
    private ListDataModel usuarios;
    
    public String nomeSetor;
    
    public List<Usuario> lista(){
        return (List<Usuario>) usuarios;
    }
    
    public ListDataModel getUsuarios(){
        return this.usuarios;
    }
    
    public void setUsuarios(ListDataModel Usuarios){
        this.usuarios = Usuarios;
    }
    
    private void recuperarTodos(){
        this.usuarios = new ListDataModel(usuarioFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarTodos();
    }
    
    public Usuario getUsuario(){
        if(this.usuario == null){
            this.usuario = new Usuario();
        }
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public String salvar(){
        if(verificaUsuario()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaUsuario(){  
        if(this.usuarioFacade.find(this.usuario.getIdUsuario()) == null){
            return true;
        } else return false;
    }
    
    public String inserir(){
        this.usuarioFacade.create(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly","Salvo com Sucesso!"));
        return null;
    }
    
    public String atualizar(){
        this.usuarioFacade.edit(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String login(){
        List<Usuario> users;
        users = usuarioFacade.recuperaUsuario(usuario);
        
        for(Usuario u : users){           
            if(u.getSenha().equals(usuario.getSenha())){
                this.nomeSetor = setorFacade.findSetor(u.getIdSetor().getIdSetor()).getNmSetor();
                return "paginas/" + this.nomeSetor;
            }
            else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Falha", "Senha Incoreta!"));
                
                return null;
            }
        }
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/" + this.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/usuario/inserirUsuario";
    }
    
    public String montarPaginaListar(){
        return "/Crud/usuario/listarUsuario";
    }
    
    public UsuarioManagedBean() {
    }
}
