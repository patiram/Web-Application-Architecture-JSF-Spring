package com.j3ltd.web;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.*;

public class Welcome {
    private HashMap<String, Locale> locales = null;

    public Welcome() {
        locales = new HashMap<String, Locale>(4);
        locales.put("english", new Locale("en", "UK"));
        locales.put("french", new Locale("fr", "FR"));
    }
    
    public void onChooseLocale(ActionEvent event) {
        String current = event.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }
}
