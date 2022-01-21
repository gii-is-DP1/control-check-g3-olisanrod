package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{
	
	@Autowired
	private RecoveryRoomService serv;

    @Override
    public String print(RecoveryRoomType object, Locale locale) {
    	String name = object.getName();
        return name;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType type = this.serv.getRecoveryRoomType(text);
    	if(type == null) {
    		throw new ParseException(text, 0);
    	}
    	return type;
    }
    
}
