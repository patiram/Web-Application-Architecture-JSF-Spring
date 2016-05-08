/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Tony
 */
@FacesValidator("com.example.validators.Email")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (value == null||value.equals("")) {
            return;
        } 
        String email = value.toString();
        if (!emailCheck(email)) {
            FacesMessage message = com.corejsf.Messages.getMessage(
                    "com.corejsf.messages", "email format incorrect!", null);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

    public boolean emailCheck(String email) {
        int numOfAt = 0;
        boolean result = true;
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (ch == '@') {
                numOfAt++;
                if (i == 0 || i == email.length() - 1) {//the first character is @
                    result = false;
                    break;
                }
            }
        }
        if (numOfAt != 1) {//no @ or more than 1
            result = false;
        }
        return result;
    }
}
