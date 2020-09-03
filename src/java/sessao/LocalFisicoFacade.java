/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.LocalFisico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Monita
 */
@Stateless
public class LocalFisicoFacade extends AbstractFacade<LocalFisico> {

    @PersistenceContext(unitName = "CLINICAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalFisicoFacade() {
        super(LocalFisico.class);
    }
    
    public List<LocalFisico> recuperarTodos(){
        return em.createQuery("Select l from LocalFisico l").getResultList();
    }
}
