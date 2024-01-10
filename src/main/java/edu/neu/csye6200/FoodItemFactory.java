package edu.neu.csye6200;

public class FoodItemFactory extends ItemFactory{

	public Item getObject() {
		return FoodItem.getInstance();
	}
	
	public Item getObject(String s) {
		return FoodItem.getInstance(s);
	}
}
