package mum.edu.corejsf;

import java.io.Serializable;
import javax.inject.Named;
// or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
// or import javax.faces.bean.SessionScoped;

@Named("user") // or @ManagedBean(name="user")  
@SessionScoped
public class User implements Serializable {

    private String name;
    private String password;
    private static boolean loggedIn = false;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

    public String login() {
        if (getName().equals("patiram") && getPassword().equals("patiram")) {
            loggedIn = true;
            return "teastore";
        } else {
            return "";
        }
    }

    public void checkLogin(ComponentSystemEvent event) {
        if (!loggedIn) {
            FacesContext context = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
            handler.performNavigation("home");
        }
    }
    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        handler.performNavigation("home");
    }
}
