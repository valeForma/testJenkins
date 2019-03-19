package apachecamelkafka.camelKafka;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomProcessor  implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\n\nroute calledddddd\n\n");

		exchange.getIn().getHeaders().keySet().stream()
		.map(x -> exchange.getIn().getHeaders().get(x).toString())
		.forEach(System.out::println);
		exchange.getOut().setBody("cazzo figa");
	}

}
