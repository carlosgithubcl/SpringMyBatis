package com.app.presentacion;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.app.com.app.utils.SessionUtils;


import com.app.integracion.model.Profesor;
import com.app.negocio.profesor.ProfesorServicio;

@ManagedBean
@SessionScoped
public class BeanProfesor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{profesorServicio}")
	private ProfesorServicio profesorServicio;


    private String username;
    private String pass;

    private Profesor profesor;

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ProfesorServicio getProfesorServicio() {
		return profesorServicio;
	}

	public void setProfesorServicio(ProfesorServicio profesorServicio) {
		this.profesorServicio = profesorServicio;
	}

	public List<Profesor> consultarProfesores(){
		return profesorServicio.consultarTodos();
	}

    /**
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, username+pass, "Holi" ));
     }


    public String getProfe(){
        return  profesorServicio.getProfe().getUsername()+profesorServicio.getProfe().getPass();
    }
    **/

    public String controladorLogin( ) {
        Profesor profeEntrada = new Profesor();
        profeEntrada.setUsername(username);
        profeEntrada.setPass(pass);

        profesor = profesorServicio.getProfe(profeEntrada);

        if(profesor != null){
            if(username.equals(profesor.getUsername()) &&  pass.equals(profesor.getPass())) {
            //HttpSession session = SessionUtils.getSession();
            //session.setAttribute("username", profesor.getUsername());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",profesor);

            return "mantenedor";
        }
    }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Usuario y/o Clave Incorrectos",
                "Please Try Again!"));

        return "login";
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();

        return "login";
    }

    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            //Castear profesor
            Profesor profe = (Profesor) context.getExternalContext().getSessionMap().get("usuario");

            if(profe == null){
                context.getExternalContext().redirect("./permisos.xhtml");
            }

        }catch(Exception e){

        }
    }
}
