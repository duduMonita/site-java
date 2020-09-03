/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.Alergia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Monita
 */
@Stateless
public class AlergiaFacade extends AbstractFacade<Alergia> {

    @PersistenceContext(unitName = "CLINICAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlergiaFacade() {
        super(Alergia.class);
    }
    
    public List<Alergia> recuperarTodos(){
        return em.createQuery("Select a from Alergia a").getResultList();
    }
}
