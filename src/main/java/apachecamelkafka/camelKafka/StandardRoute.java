package apachecamelkafka.camelKafka;

import org.apache.camel.builder.RouteBuilder;

public class StandardRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:test.txt")
		 //.process( new CustomProcessor())
		 .to("file:test1.txt");
	}

	
}
