/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.Controller;

import mum.edu.model.PersionModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author PatiRam
 */

@Named("controlPerson")
@SessionScoped
public class PersonController implements Serializable{
    List<PersionModel> persons;
    PersionModel person;
    public PersonController() {
        person = new PersionModel();
        persons = new ArrayList<>();
        persons.add(new PersionModel("patiram", "yadav", "patiram@gmail.com","1000N 4th Street Fierfield", "IA", 52557));
        persons.add(new PersionModel("Anish", "Panthi", "anish@gmail.com","1000N 4th Street Fierfield", "IA", 52557));
        persons.add(new PersionModel("pati222", "yadav", "patiram@gmail.com","1000N 4th Street Fierfield", "IA", 52557));
    }

    public List<PersionModel> getPersons() {
        return persons;
    }

    public void setPersons(List<PersionModel> persons) {
        this.persons = persons;
    }

    public PersionModel getPerson() {
        return person;
    }

    public void setPerson(PersionModel person) {
        this.person = person;
    }
    
    public void getPersonInfo(){
        for(PersionModel p: persons){
            if(p.getFirstName().equalsIgnoreCase(this.person.getFirstName())){
                this.person.setLastName(p.getLastName());
                this.person.setEmailAddress(p.getEmailAddress());
                this.person.setStreet(p.getStreet());
                this.person.setState(p.getState());
                this.person.setZip(p.getZip());
            }
        }
    }
    public void valueChangeListener(ValueChangeEvent e){
        for(PersionModel p: persons){
            if(p.getFirstName().equalsIgnoreCase(e.getNewValue().toString())){
                this.person.setLastName(p.getLastName());
                this.person.setEmailAddress(p.getEmailAddress());
                this.person.setStreet(p.getStreet());
                this.person.setState(p.getState());
                this.person.setZip(p.getZip());
            }
        }
    }
}
