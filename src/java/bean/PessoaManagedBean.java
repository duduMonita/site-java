package bean;

import entidades.Pessoa;
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
import sessao.PessoaFacade;

@Named(value = "pessoaManagedBean")
@ManagedBean(name="pessoaManagedBean")
@SessionScoped
public class PessoaManagedBean implements Serializable {

    @ManagedProperty(value = "#{usuarioManagedBean}")
    private UsuarioManagedBean usuarioManagedBean;
    
    @EJB
    private PessoaFacade pessoaFacade;
    
    private Pessoa pessoa;
    
    private ListDataModel pessoas;
    
    public List<Pessoa> lista(){
        return (List<Pessoa>) pessoas;
    }
    
    public ListDataModel getPessoas(){
        return this.pessoas;
    }
    
    public void setPessoas(ListDataModel pessoas){
        this.pessoas = pessoas;
    }
    
    private void recuperarTodos(){
        this.pessoas = new ListDataModel(pessoaFacade.recuperarTodos());
    }
    
    public void recuperar(){
        this.recuperarTodos();
    }
    
    public Pessoa getPessoa(){
        if(this.pessoa == null){
            this.pessoa = new Pessoa();
        }
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    
    public String salvar(){
        if(verificaPessoa()){
            return atualizar();
        }
        else {
            return inserir();
        }
    }   
    
    public boolean verificaPessoa(){
        if(this.pessoaFacade.find(this.pessoa.getIdPessoa()) == null){
            return true;
        } else return false;
    }
    
    public String inserir(){
        this.pessoaFacade.create(pessoa);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly","Salvo com Sucesso!"));
        return null;
    }
    
    public String atualizar(){
        this.pessoaFacade.edit(pessoa);
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Succesfuly", "Atualizado com Sucesso!"));
        return null;
    }
    
    public String montarPaginaVoltar(){
        return "/paginas/" + usuarioManagedBean.nomeSetor;
    }
    
    public String montarPaginaSalvar(){
        return "/Crud/pessoa/inserirPessoa";
    }
    
    public String montarPaginaListar(){
        return "/Crud/pessoa/listarPessoa";
    }
    
    public PessoaManagedBean() {
    }
    
    public void setUsuarioManagedBean(UsuarioManagedBean usuarioManagedBean) {
        this.usuarioManagedBean = usuarioManagedBean;
    }
}
