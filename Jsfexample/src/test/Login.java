package test;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.catalina.manager.util.SessionUtils;


@ManagedBean
@SessionScoped
public class Login implements Serializable {
private static final long serialVersionUID=1094801825228386363L;
private String pwd;
private String msg;
private String user;
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
//validate login
public String validateUsernamePassword(){
	boolean valid=LoginDAO.validate(user, pwd);
	if(valid){
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("username",user);
		return "admin";
	}
	else{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Password","Please enter correct Username and Password"));
		return "login";
	}
	
	
}
}
