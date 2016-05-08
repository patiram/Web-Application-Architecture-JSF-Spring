/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Tony
 */
@FacesValidator("com.example.validators.Zip")
public class ZipValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (value == null||value.equals("")) {
            return;
        }
        UIInput stateInput = (UIInput) component.findComponent("state");
        String state = stateInput.getLocalValue().toString();
        int zip = Integer.parseInt(value.toString());
        if (!zipCheck(state, zip)) {
            FacesMessage message = com.corejsf.Messages.getMessage(
                    "com.corejsf.messages", "zip is not corresponding to state!", null);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

    public boolean zipCheck(String state, int zip) {
        boolean result = true;
        if (state.equalsIgnoreCase("IA")) {
            if (zip / 10000 != 5) {
                result = false;    
            }
        }
        return result;
    }
}
