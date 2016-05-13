package mum.edu.corejsf;

import java.io.Serializable;
import javax.inject.Named; 
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;

@Named // or @ManagedBean
@RequestScoped
public class Tea implements Serializable {
  private String selectedTea;
  User user;
  
  public Tea(){
      user = new User();
  }
  public String getSelectedTea() { return selectedTea; }
  
  public String changeTea(String newValue) {
     selectedTea = newValue;
     return selectedTea;
  }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
