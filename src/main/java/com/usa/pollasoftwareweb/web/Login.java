package com.usa.pollasoftwareweb.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.usa.pollasoftwareweb.vista.JugadorJpaController;

import com.usa.pollasoftwareweb.entidad.Jugador;
import com.usa.pollasoftwareweb.seguridad.SessionUtils;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    @EJB
    JugadorJpaController jugadorController;

    private static final long serialVersionUID = 1094801825228386363L;

    private String password;
    private String user;
    private String alias;

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String validateUsernamePassword() {
        Jugador jugador = jugadorController.findJugador(user);

        if (jugador != null) {
            if (jugador.getPassword().equalsIgnoreCase(password)) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", jugador);
                alias = jugador.getAlias();
                if (jugador.getAdministrador()) {
                    return "menuAdministrador";
                }
                return "menuJugador";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Contraseña o nombre de usuario incorrectos",
                            "Por favor verifique nombre de usuario y contraseña"));
            return "index";
        }
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Contraseña o nombre de usuario incorrectos",
                        "Por favor verifique nombre de usuario y contraseña"));
        return "index";
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
}
