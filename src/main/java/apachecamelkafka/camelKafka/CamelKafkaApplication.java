package apachecamelkafka.camelKafka;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javassist.expr.NewArray;

@SpringBootApplication
public class CamelKafkaApplication {

	public static void main(String[] args) {
		 SpringApplication.run(CamelKafkaApplication.class, args);
	
//		 SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();
        try {
            ctx.addRoutes(new StandardRoute());
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
