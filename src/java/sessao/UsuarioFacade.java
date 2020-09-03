/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Monita
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "CLINICAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> recuperaUsuario(Usuario user){
        return em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login").setParameter("login", user.getLogin()).getResultList();
    }
    
    public List<Usuario> recuperarTodos(){
        return em.createQuery("Select u from Usuario u").getResultList();
    }
}
