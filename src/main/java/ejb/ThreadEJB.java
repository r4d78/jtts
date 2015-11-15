package ejb;

import entity.PostEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dni
 */
@Stateless
public class ThreadEJB {

    @PersistenceContext(unitName = "com.mycompany_jtts_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public void create(PostEntity post){
        em.persist(post);
    }
    
}
