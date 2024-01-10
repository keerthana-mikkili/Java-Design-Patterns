package edu.neu.csye6200;

public class FoodItem extends Item{

	private static FoodItem instance;
	
	public FoodItem(String input) {
		super(Integer.parseInt(input.split(",")[0]),input.split(",")[1],Double.parseDouble(input.split(",")[2]));
	
	}
	
	private FoodItem() {
		instance=null;
	}
	
	public static FoodItem getInstance() {
		
		if(instance==null)
		{
			instance=new FoodItem();
		}
		return instance;
	}
	public static FoodItem getInstance(String input) {
		instance = new FoodItem(input);
	return instance;
}

	public FoodItem(int id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FoodItem [toString()=" + super.toString() + "]";
	}
}
