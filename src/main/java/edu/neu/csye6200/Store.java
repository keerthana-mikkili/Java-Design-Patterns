package edu.neu.csye6200;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Store extends AbstractStore {

	private static List<FoodItem> foodItemList = new ArrayList<>();
	private static List<ElectronicItem> electronicItemList = new ArrayList<>();
	private static List<ServiceItem> serviceItemList = new ArrayList<>();
	static String outputFileName = "outputdatacsv.txt";

	public void addToFoodItemList(FoodItem foodItem) {
		foodItemList.add(foodItem);

	}

	public void addToElectronicItemList(ElectronicItem eItem) {
		electronicItemList.add(eItem);

	}

	public void addToServiceItemList(ServiceItem sItem) {
		serviceItemList.add(sItem);

	}

	public List<ElectronicItem> getElectronicItemList() {
		return electronicItemList;
	}

	public void setElectronicItemList(List<ElectronicItem> electronicItemList) {
		this.electronicItemList = electronicItemList;
	}

	public List<ServiceItem> getServiceItemList() {
		return serviceItemList;
	}

	public void setServiceItemList(List<ServiceItem> serviceItemList) {
		this.serviceItemList = serviceItemList;
	}

	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}

	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}

	public void demo() {

		ItemFactory foodItemFactory = new FoodItemFactory();
		ItemFactory electronicItemFactory = new ElectronicItemFactory();
		ItemFactory serviceItemFactory = new ServiceItemFactory();

		Store sobj = new Store();

		fillItems("FoodItemCSV.txt", sobj, foodItemFactory);
		fillItems("ElectronicItemCSV.txt", sobj, electronicItemFactory);
		fillItems("serviceItemCSV.txt", sobj, serviceItemFactory);

		System.out.println("-------------FoodItemsList---------------");
		System.out.println("Sorted FoodItems by Id");
		Collections.sort(sobj.getFoodItemList());
		printFoodItems(sobj);
		FileUtil.outputcsv("ID", foodItemList, true, sobj);
		System.out.println("Sorted FoodItems by Name");
		Collections.sort(sobj.getFoodItemList(), (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
		printFoodItems(sobj);
		FileUtil.outputcsv("Name", foodItemList, true, sobj);
		System.out.println("Sorted FoodItems by Price");
		Collections.sort(sobj.getFoodItemList(), (f1, f2) -> Double.compare(f1.getPrice(), f2.getPrice()));
		printFoodItems(sobj);
		FileUtil.outputcsv("Price", foodItemList, true, sobj);

		System.out.println("------------ElectronicItemsList-----------");
		System.out.println("Sorted ElectronicItems by Id");
		Collections.sort(sobj.getElectronicItemList());
		printElectronicItems(sobj);
		FileUtil.outputcsv("ID", electronicItemList, true, sobj);
		System.out.println("Sorted ElectronicItems by Name");
		Collections.sort(sobj.getElectronicItemList(), (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
		printElectronicItems(sobj);
		FileUtil.outputcsv("Name", electronicItemList, true, sobj);
		System.out.println("Sorted ElectronicItems by Price");
		Collections.sort(sobj.getElectronicItemList(), (f1, f2) -> Double.compare(f1.getPrice(), f2.getPrice()));
		printElectronicItems(sobj);
		FileUtil.outputcsv("Price", electronicItemList, true, sobj);

		System.out.println("-------------ServiceItemsList------------");
		System.out.println("Sorted ServiceItems by Id");
		Collections.sort(sobj.getServiceItemList());
		printServiceItems(sobj);
		FileUtil.outputcsv("ID", serviceItemList, true, sobj);
		System.out.println("Sorted ServiceItems by Name");
		Collections.sort(sobj.getServiceItemList(), (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
		printServiceItems(sobj);
		FileUtil.outputcsv("Name", serviceItemList, true, sobj);
		System.out.println("Sorted ServiceItems by Price");
		Collections.sort(sobj.getServiceItemList(), (f1, f2) -> Double.compare(f1.getPrice(), f2.getPrice()));
		printServiceItems(sobj);
		FileUtil.outputcsv("Price", serviceItemList, true, sobj);

	}

	public void fillItems(String fileName, Store sobj, ItemFactory itemFactory) {
		FileUtil file = new FileUtil();
		try {
			String[] Array = file.read(System.getProperty("user.dir") + "/" + fileName).split("\n");
			for (String s : Array) {
				if (fileName.equals("FoodItemCSV.txt"))
					sobj.addToFoodItemList((FoodItem) itemFactory.getObject(s));
				if (fileName.equals("ElectronicItemCSV.txt"))
					sobj.addToElectronicItemList((ElectronicItem) itemFactory.getObject(s));
				if (fileName.equals("serviceItemCSV.txt"))
					sobj.addToServiceItemList((ServiceItem) itemFactory.getObject(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printFoodItems(Store sobj) {
		StringBuilder builder = new StringBuilder();
		System.out.println();
		for (FoodItem foodItem : sobj.getFoodItemList()) {
			builder.append(foodItem);
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

	public void printElectronicItems(Store sobj) {
		StringBuilder builder = new StringBuilder();
		System.out.println();
		for (ElectronicItem electronicItem : sobj.getElectronicItemList()) {
			builder.append(electronicItem);
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

	public void printServiceItems(Store sobj) {
		StringBuilder builder = new StringBuilder();
		System.out.println();
		for (ServiceItem serviceItem : sobj.getServiceItemList()) {
			builder.append(serviceItem);
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}
}
