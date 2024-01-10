package edu.neu.csye6200;

public class ElectronicItemFactory extends ItemFactory{

	public Item getObject() {
		return ElectronicItem.getInstance();
	}
	public Item getObject(String s) {
		return ElectronicItem.getInstance(s);
	}
}
