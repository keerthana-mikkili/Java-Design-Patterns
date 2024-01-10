package edu.neu.csye6200;

public class ServiceItem extends Item{

	private static ServiceItem instance = new ServiceItem();
	
	public ServiceItem(String input) {
		super(Integer.parseInt(input.split(",")[0]),input.split(",")[1],Double.parseDouble(input.split(",")[2]));
	}
	
	private ServiceItem() {
		
	}

	public static ServiceItem getInstance() {
		return instance;
	}
	
	public static  ServiceItem getInstance(String input) {
		instance = new ServiceItem(input);
	return instance;
}
	
	public ServiceItem(int id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ServiceItem [toString()=" + super.toString() + "]";
	}

}
