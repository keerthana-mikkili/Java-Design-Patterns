package edu.neu.csye6200;

public class ServiceItemFactory extends ItemFactory{

	public Item getObject() {
		return ServiceItem.getInstance();
	}
	public Item getObject(String s) {
		return ServiceItem.getInstance(s);
	}
}
