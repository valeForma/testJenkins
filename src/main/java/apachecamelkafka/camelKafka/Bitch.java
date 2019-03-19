package apachecamelkafka.camelKafka;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Bitch implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3815372400773743495L;
	@SerializedName("alla_botta")
	private int price;
	private boolean available;
	public String description;
	public String name;
	private Date time; 
	public Bitch() {
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Bitch [price=" + price + ", available=" + available + ", description=" + description + ", name=" + name
				+ "]";
	}
	
}
