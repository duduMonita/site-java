/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.Medico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Monita
 */
@Stateless
public class MedicoFacade extends AbstractFacade<Medico> {

    @PersistenceContext(unitName = "CLINICAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicoFacade() {
        super(Medico.class);
    }
    
    public List<Medico> recuperarTodos(){
        return em.createQuery("Select m from Medico m").getResultList();
    }
}
