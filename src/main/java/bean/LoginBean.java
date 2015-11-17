/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AuthEJB;
import entity.AuthEntity;
import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * ログイン画面のBackingBean
 */
@Named(value = "LoginBean")
@RequestScoped
public class LoginBean {
    /**
     * ユーザーコード
     */
    private String userCd;
    /**
     * パスワード
     */
    private String password;
    /**
     * ユーザーマスタ操作EJB
     */
    @EJB
    private AuthEJB authEJB;

    /**
     * コンストラクタ
     */
    public LoginBean() {
    }

    /**
     * ログイン処理
     * @param ptn "mobile" or "pc"
     * @return ログイン成功時の遷移先画面
     */
    public String login(String ptn){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
        
        //ログイン
        try{
            request.login(getUserCd(), getPassword());
        }catch(ServletException ex){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ログインに失敗しました。","ユーザー名・パスワードを正しく入力して下さい。"));
            return "";
        }
        
        if (ptn.equals("mobile")){
            return "/contents/mobile/mainmenu.xhtml?faces-redirect=true";
        }else{
            return "/contents/pc/mainmenu.xhtml?faces-redirect=true";
        }
    }

    /**
     * ログアウト処理
     * @param ptn "mobile" or "pc"
     * @return ログアウト成功時の遷移先画面
     */
    public String logout(String ptn){
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
        try{
            request.logout();
        }catch(ServletException ex){
            return ex.getMessage();
        }
        if (ptn.equals("mobile")){
            return "/mobile/login.xhtml?faces-redirect=true";
        }else if (ptn.equals("pc")){
            return "/pc/login.xhtml?faces-redirect=true";
        }else{
            return "/index.xhtml?faces-redirect=true";
        }
    }
    
    /**
     * ログイン済の時にログイン画面のURLを指定された場合にメインメニュー画面に戻す
     * @param ptn
     * @throws ServletException 
     */
    public void onPageLoad(String ptn) throws ServletException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
        Principal principal = request.getUserPrincipal();
        if (principal != null){
            try{
                StringBuilder redirectURL = new StringBuilder(request.getContextPath());
                if (ptn.equals("mobile")){
                        redirectURL.append("/faces/contents/mobile/mainmenu.xhtml");
                }else{
                        redirectURL.append("/faces/contents/pc/mainmenu.xhtml");
                }
                FacesContext.getCurrentInstance().getExternalContext().redirect(redirectURL.toString());
            }catch(IOException ex){
                request.logout();
            }
        }
    }
    
    public String getUserCd() {
        return userCd;
    }

    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
