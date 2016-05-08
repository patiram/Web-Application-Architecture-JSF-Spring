import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
 
@Named("pb")
@RequestScoped
public class PersonBean implements Serializable
{
  private String firstName = "bob";
  private String lastName = "white";
  private boolean asynChecked;
  private String requestType=null;
  public PersonBean()
  {
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getLastName() 
  {
    return lastName;
  }
  
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
 
  public String getFullName()
  {
    return String.format("%s %s", firstName, lastName);
  }
    public boolean isAsynChecked() {
        return asynChecked;
    }

    public void setAsynChecked(boolean asynChecked) {
        this.asynChecked = asynChecked;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

 
}