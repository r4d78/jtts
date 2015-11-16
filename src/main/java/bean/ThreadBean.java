package bean;

import ejb.ThreadEJB;
import entity.PostEntity;
import java.sql.Date;
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
public class ThreadBean {
    private Long id;
    private Long boardId;
    private Long postNum;
    private String name;
    private String content;
    private Date postDate;
    private Long orgPost;
    
    private String message;
    
    @EJB
    ThreadEJB threadEJB;
    
    public String create(){
        PostEntity thread = new PostEntity(id, boardId, postNum, name, content, postDate, orgPost);
        try{
            threadEJB.create(thread);
        }catch(Exception e){
            System.out.println("error occured");
            e.printStackTrace();
        }
        return "thread_list.xhtml";
    }
    
    public String pushed(){
        this.message = "OMG WTF";
        return "demo.xhtml";
    }
}
