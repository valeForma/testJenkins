package apachecamelkafka.camelKafka.Models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill {

	@JsonProperty
	private String billNumber;
	@JsonProperty
	private double billPrice;
	@JsonProperty
	@JsonFormat(
		      shape = JsonFormat.Shape.STRING,
		      pattern = "dd-MM-yyyy")
	private Date billDate;
	
	private BillPart billPart;
	
	private Map<String,String> unknownItems=new HashMap<String,String>();
	
	public Bill() {
		
	}
	
	@JsonAnySetter
	public void add(String key,String value) {
		unknownItems.put(key, value);
		
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public double getBillPrice() {
		return billPrice;
	}

	public void setBillPrice(double billPrice) {
		this.billPrice = billPrice;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	@JsonAnyGetter
	public Map<String, String> getUnknownItems() {
		return unknownItems;
	}

	

	public BillPart getBillPart() {
		return billPart;
	}

	public void setBillPart(BillPart billPart) {
		this.billPart = billPart;
	}
	
}
