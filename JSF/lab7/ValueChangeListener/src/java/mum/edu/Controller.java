/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author PatiRam
 */
@Named("control")
@SessionScoped
public class Controller implements Serializable {

    private List<Person> persons;
    private Person person;

    public Controller() {
        persons = new ArrayList<>();
        person = new Person();
    }

    public Person getPerson() {
//       person = new Person();
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void save() {
        persons.add(new Person(person.getFirstName(), person.getLastName()));
    }

    public void onValueChanged(ValueChangeEvent event) {

        for (Person person : persons) {
            if (person.getFirstName().equalsIgnoreCase(event.getNewValue() + "")) {
                this.person.setLastName(person.getLastName());
                break;
            }
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

    public String findLastName() {
        for (Person person : persons) {
            if (person.getFirstName().equalsIgnoreCase(this.person.getFirstName())) {
                this.person.setLastName(person.getLastName());
                break;
            }
        }
        return "index";
    }
}
