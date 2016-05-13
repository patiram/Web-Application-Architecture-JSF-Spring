package com.j3ltd.web;

import com.j3ltd.common.*;
import com.j3ltd.server.sessionremote.*;
import com.j3ltd.server.entities.*;
import com.j3ltd.server.exceptions.*;
import com.j3ltd.web.messages.*;
import java.util.*;

import javax.faces.context.*;
import javax.faces.application.*;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Register {

	Person person;
	private String passwordConfirm;
	private String emailConfirm;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<SelectItem> getGenders() {
		ArrayList<SelectItem >genders = new ArrayList<SelectItem>();
		MessageFactory msg = new MessageFactory();
			
		SelectItem item = new SelectItem();		
		item.setLabel(msg.getMessage("male"));
		item.setValue(Gender.Male.toString());
		genders.add(item);
		item = new SelectItem();
		item.setLabel(msg.getMessage("female"));
		item.setValue(Gender.Female.toString());
		genders.add(item);
		item = new SelectItem();
		item.setLabel(msg.getMessage("undisclosed"));
		item.setValue(Gender.Undisclosed.toString());
		genders.add(item);
		return genders;
	}
	
	public List<SelectItem> getMaritalStati() {
		ArrayList<SelectItem> maritalStati = new ArrayList<SelectItem>();
		MessageFactory msg = new MessageFactory();
		
		SelectItem item = new SelectItem();		
		item.setLabel(msg.getMessage("married"));
		item.setValue(MaritalStatus.Married.toString());
		maritalStati.add(item);
		item = new SelectItem();
		item.setLabel(msg.getMessage("single"));
		item.setValue(MaritalStatus.Single.toString());
		maritalStati.add(item);
		item = new SelectItem();
		item.setLabel(msg.getMessage("undisclosed"));
		item.setValue(MaritalStatus.Undisclosed.toString());
		maritalStati.add(item);
		return maritalStati; 
	}
	
	public String register() throws Exception {
		String toReturn = "failure";
		   
		if (validateData()) {
			try {
				// save locale information, in case the user chose a language on the welcome page
				Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
				person.setLocaleCountry(locale.getCountry());
				person.setLocaleLanguage(locale.getLanguage());
				
				Context context = new InitialContext();
				EntityFacade entities = (EntityFacade) context.lookup("EntityFacadeBean/remote");
				person = entities.createPerson(person);
				toReturn = "success";
			} 
			catch (PersonEntityExistsException exist) {
				MessageFactory msg = new MessageFactory();
				FacesContext ctx = FacesContext.getCurrentInstance();
				
				ctx.addMessage("registerForm:email", 
						new FacesMessage(FacesMessage.SEVERITY_ERROR, 
								msg.getMessage("errorEmailExists"), null));
			}					
		}
		return toReturn;
	}
	
	/**
	 * Perform validation that can only be done once 
	 * all the field data is present
	 * in the person member. Ie: to validate one field 
	 * other field(s) values are needed.
	 * 
	 * Note that this method creates error messages for the 
	 * faces context, if errors are found.
	 * @return true if data is OK, false if not OK
	 */
	private boolean validateData() {
		boolean toReturn = true;
		MessageFactory msg = new MessageFactory();
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		// check emailConfirm is same as email
		if (!emailConfirm.equals(person.getEmail())) {
			ctx.addMessage("registerForm:emailConfirm", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							msg.getMessage("errorEmailConfirm"), null));
			toReturn = false;
		}
		// check passwordConfirm is same as password
		if (!passwordConfirm.equals(person.getPassword())) {
			ctx.addMessage("registerForm:passwordConfirm", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							msg.getMessage("errorPasswordConfirm"), null));
			toReturn = false;
		}
		return toReturn;
	}
	
	public String getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
