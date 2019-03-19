package apachecamelkafka.camelKafka.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import apachecamelkafka.camelKafka.Models.Bill;
import apachecamelkafka.camelKafka.Models.BillPart;

@RestController
public class BillController {

	@PostMapping(path="/bill")
	@ResponseBody
	public Bill putBill(@RequestBody Bill bill) throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode jsonNode=objectMapper.readTree(objectMapper.writeValueAsString(bill));
		Bill b=new Bill();
		b.setBillDate(new Date());
		b.setBillNumber(jsonNode.get("billNumber").asText());
		BillPart bPart= new BillPart();
		bPart.setId(jsonNode.get("billPart").get("id").asText());
		b.setBillPart(bPart);
		
		return b;
	}
	
}
