package bean;

import ejb.AuthEJB;
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
public class AuthBean {
    private Long id;
    private String name;
    private String password;
    private String mail;
    
    @EJB
    AuthEJB authEJB;

    public void none(){
        
    }
}
