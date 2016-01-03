package ejb;

import dao.PostDao;
import dao.ThreadDao;
import entity.PostEntity;
import entity.ThreadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
    
    @Inject
    ThreadDao threadDao;
    
    @Inject
    PostDao postDao;
    
    public void test(){
    }
    
    public void create(PostEntity post){
        em.persist(post);
    }

    public List<ThreadEntity> loadThreadList() {
        return threadDao.searchRecentIgnited();
    }

    public List<PostEntity[]> loadPostList(List<ThreadEntity> list) {
        return postDao.searchRecentPost(list);
    }
    
}
