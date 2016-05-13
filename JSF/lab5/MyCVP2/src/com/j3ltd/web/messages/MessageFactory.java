package com.j3ltd.web.messages;

import java.util.*;
import javax.faces.context.*;
import java.text.*;

public class MessageFactory {
	ResourceBundle bundle;
	Locale locale;
	
	public MessageFactory() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	bundle = ResourceBundle.getBundle("com.j3ltd.web.messages.ApplicationMessages", locale);
	}
	
	public String getMessage(String key) {
		return bundle.getString(key);
	}
	public String getMessage(String key, Object arg1) {
		return getMessage(key, new Object[] {arg1});
	}
	public String getMessage(String key, Object arg1, Object arg2) {
		return getMessage(key, new Object[] {arg1, arg2});
	}
	public String getMessage(String key, Object[] args) {
		if (args == null || args.length == 0) {
			return bundle.getString(key);
		}
		MessageFormat fmt = new MessageFormat(bundle.getString(key));
		fmt.setLocale(locale);
		return fmt.format(args).toString();
	}
}
