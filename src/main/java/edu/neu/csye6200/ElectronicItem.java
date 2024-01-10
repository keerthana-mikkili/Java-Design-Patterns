package edu.neu.csye6200;

public class ElectronicItem extends Item{

	private static ElectronicItem instance;
	
	public ElectronicItem(String input) {
		super(Integer.parseInt(input.split(",")[0]),input.split(",")[1],Double.parseDouble(input.split(",")[2]));
	}
	private ElectronicItem() {
		instance=null;
	}
	
	public static synchronized ElectronicItem getInstance() {
		if(instance==null)
		{
			instance=new ElectronicItem();
		}
		return instance;
	}
	
	public static  ElectronicItem getInstance(String input) {
		instance = new ElectronicItem(input);
	return instance;
    }
	
	public ElectronicItem(int id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ElectronicItem [toString()=" + super.toString() + "]";
	}
	
}
