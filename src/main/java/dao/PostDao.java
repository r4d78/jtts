/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PostEntity;
import entity.ThreadEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dni
 */
@Stateless
public class PostDao extends DataAccessBase {

    public PostDao() {
        super(PostEntity.class);
    }
    
    public void loadPostList(){
        
    }

    public List<PostEntity[]> searchRecentPost(List<ThreadEntity> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
