package apachecamelkafka.camelKafka;

import java.io.IOException;

import javax.management.Notification;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaOutputBean {
	
	public void printKafkaBody(Bitch body) {
		
			//Bitch message = new ObjectMapper().readValue(body,Bitch.class);
			System.out.println("KafkaBody result >>>>> " + body.toString());
		

	}

}
