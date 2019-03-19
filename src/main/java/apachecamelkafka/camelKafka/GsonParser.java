package apachecamelkafka.camelKafka;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class GsonParser {

	public GsonParser() {
		
	}
	public List<RedHouse> Parse(String string) {
		GsonBuilder gson = new GsonBuilder();
		gson.registerTypeAdapter(Date.class,new DateDeserializer());
		Gson parser=gson.create();
		Type collectionType=new TypeToken<Collection<RedHouse>>(){}.getType();
		return parser.fromJson(string,collectionType );
		
	}
	private class DateDeserializer implements JsonDeserializer<Date> {
		  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
		      throws JsonParseException {
			  SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
			  Date retDate=new Date();
			  try {
				 retDate= simpleDateFormat.parse((json.getAsJsonPrimitive().getAsString()));
			  }
			  catch(ParseException ex) {
				  System.out.println(ex);
			  }
		    return retDate;
		  }
		}
}
