/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.AuthEntity;
import entity.ThreadEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dni
 */
@Stateless
public class ThreadDao extends DataAccessBase {

    public ThreadDao() {
        super(ThreadEntity.class);
    }
    
    public Object some(Long id, String password){
        List<AuthEntity> list = em.createNamedQuery("AuthEntity.canLogin", AuthEntity.class)
                .setParameter("id", id).setParameter("password", password).getResultList();
        return !list.isEmpty();
    }

    public List<ThreadEntity> searchRecentIgnited() {
        return em.createNamedQuery("ThreadEntity.findRecentIgnited", entityClass)
                .setMaxResults(9).getResultList();
    }
}
