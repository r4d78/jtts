/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.AuthEntity;
import java.util.List;

/**
 *
 * @author dni
 */
public class AuthDao extends DataAccessBase {

    public AuthDao() {
        super(AuthEntity.class);
    }
    
    public Object some(Long id, String password){
        List<AuthEntity> list = em.createNamedQuery("AuthEntity.canLogin", AuthEntity.class)
                .setParameter("id", id).setParameter("password", password).getResultList();
        return !list.isEmpty();
    }
}
