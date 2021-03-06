/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
    @NamedQuery(name = "AuthEntity.canLogin", query = "SELECT a FROM AuthEntity a WHERE a.id = :id AND a.password = :password"),
    @NamedQuery(name = "AuthEntity.something", query = "SELECT max(a.id) From AuthEntity a")})
public class AuthEntity implements Serializable, IsEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String name;
    private String mail;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthEntity)) {
            return false;
        }
        AuthEntity other = (AuthEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AuthEntity[ id=" + id + " ]";
    }
    
}
