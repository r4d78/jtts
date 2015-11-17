package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Data;

/**
 *
 * @author dni
 */
@Entity
@Data
@NamedQueries({
    @NamedQuery(name="PostEntity.findAll", query="SELECT p FROM PostEntity p"),
    @NamedQuery(name="PostEntity.findRecentPost", query="SELECT p FROM PostEntity p ORDER BY p.postDate DESC")
})
public class PostEntity implements Serializable, IsEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long boardId;
    private Long postNum;
    private String name;
    private String content;
    private Date postDate;
    private Long orgPost;

    public PostEntity(){
        
    }
    
    public PostEntity(Long id, Long boardId, Long postNum, String name, String content, Date postDate, Long orgPost) {
        this.id = id;
        this.boardId = boardId;
        this.postNum = postNum;
        this.name = name;
        this.content = content;
        this.postDate = postDate;
        this.orgPost = orgPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostEntity)) {
            return false;
        }
        PostEntity other = (PostEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PostEntity[ id=" + id + " ]";
    }
    
}
