/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.Prontuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Monita
 */
@Stateless
public class ProntuarioFacade extends AbstractFacade<Prontuario> {

    @PersistenceContext(unitName = "CLINICAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProntuarioFacade() {
        super(Prontuario.class);
    }
    
    public List<Prontuario> recuperarTodos(){
        return em.createQuery("Select p from Prontuario p").getResultList();
    }
}
