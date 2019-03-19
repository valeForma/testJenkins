package apachecamelkafka.camelKafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.logging.Slf4JLoggingSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder  {
	
	 @Bean(name = "KafkaRouteProducer")
	    public RouteBuilder kafkaRouteProducer() {
	        return new RouteBuilder() {
	            public void configure() {
	                from("direct:kafkaRoute")
	                .to("kafka:localhost:9092?topic=test&groupId=testing&autoOffsetReset=earliest&consumersCount=1")
	                .bean(KafkaOutputBean.class);
	            }
	        };
	    }

	    @Bean(name = "KafkaRouteConsumer")
	    public RouteBuilder kafkaRouteConsumer() {
	        return new RouteBuilder() {
	            public void configure() {
	                from("kafka:localhost:9092?topic=test&groupId=testing&autoOffsetReset=earliest&consumersCount=1")
	                .bean(KafkaOutputBean.class);
	            }
	        };
	    }
	    @Bean(name="standardRoute")
	    public RouteBuilder standardRoute() {
	    	return new RouteBuilder() {
	    		@Override
	    		public void configure() throws Exception {
	    			// TODO Auto-generated method stub
	    			System.out.println("\n\nroute calledddddd\n\n");
	    			try { 
	    			from("file://Users/vale/Desktop/test.txt")
	    			 //.process( new CustomProcessor())
	    			 .to("file://Users/vale/Desktop/test1.txt");
	    			}
	    			catch(Exception ex) {
	    				System.out.println(ex.getMessage());
	    			}
	    		}
	    	};
	    }
//	@Override
//	public void configure() throws Exception {
//
//		String topicName = "topic=javainuse-topic";
//		String kafkaServer = "kafka:localhost:9092";
//		String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
//		String serializerClass = "serializerClass=kafka.serializer.StringEncoder";
//
//		String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
//				.append(zooKeeperHost).append("&").append(serializerClass).toString();
//
//		from("file:/Users/vale/Desktop/test.txt?noop=true").split().tokenize("\n").to(toKafka);
//	}

}
