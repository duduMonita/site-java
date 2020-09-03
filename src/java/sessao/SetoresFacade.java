/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.Setores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Monita
 */
@Stateless
public class SetoresFacade extends AbstractFacade<Setores> {

    @PersistenceContext(unitName = "CLINICAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SetoresFacade() {
        super(Setores.class);
    }
    
    public Setores findSetor(int id){
        return em.find(Setores.class, id);
    }
    
    public List<Setores> recuperarTodos(){
        return em.createQuery("Select s from Setores s ORDER BY s.idSetor").getResultList();
    }
}
