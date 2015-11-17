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
    @NamedQuery(name="ThreadEntity.findAll", query="SELECT t FROM ThreadEntity t"),
    @NamedQuery(name="ThreadEntity.findRecentIgnited", query="SELECT t FROM ThreadEntity t ORDER BY t.lastIgnite DESC, t.id DESC")
})
public class ThreadEntity implements Serializable, IsEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date lastIgnite;
    private boolean deleteFlag;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThreadEntity)) {
            return false;
        }
        ThreadEntity other = (ThreadEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ThreadEntity[ id=" + id + " ]";
    }
    
}
