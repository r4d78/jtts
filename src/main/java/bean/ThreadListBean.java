package bean;

import ejb.ThreadEJB;
import entity.PostEntity;
import entity.ThreadEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;

/**
 *
 * @author dni
 */
@Named
@Data
@RequestScoped
public class ThreadListBean {
    
    @EJB
    ThreadEJB threadEJB;
    
    private List<ThreadEntity> threadList;
    private List<PostEntity[]> postList;
    
    public void loadThreadList(){
        threadList = threadEJB.loadThreadList();
        postList = threadEJB.loadPostList(threadList);
    }
}
