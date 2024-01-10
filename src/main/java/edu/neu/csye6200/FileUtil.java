package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.List;

public class FileUtil {

	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder=new StringBuilder(); 
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
	public String read(String path) throws IOException {
		InputStream inputStream =new FileInputStream(path);
		String data = readFromInputStream(inputStream);
		return data;
	}

	public static void outputcsv(String sortby, List list, boolean AppendToSameFile,Store obj) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Store.outputFileName, AppendToSameFile))) {
			// Write headers to the CSV file
			if (list == obj.getFoodItemList())
				writer.write("FoodItemsList");
			else if (list == obj.getElectronicItemList())
				writer.write("ElectronicItemsList");
			else
				writer.write("ServiceItemsList");

			writer.write("Sorted by " + sortby);
			writer.newLine();
			writer.write("ID,Name,Price");
			writer.newLine();
			if (list == obj.getFoodItemList()) {
				for (FoodItem s : obj.getFoodItemList()) {
					StringBuilder st = new StringBuilder();
					st.append(s.getId()).append(",");
					st.append(s.getName()).append(",");
					st.append(s.getPrice()).append(",");
					writer.write(st.toString());
					writer.newLine();
				}
			} else if (list == obj.getElectronicItemList()) {
				for (ElectronicItem s : obj.getElectronicItemList()) {
					StringBuilder st = new StringBuilder();
					st.append(s.getId()).append(",");
					st.append(s.getName()).append(",");
					st.append(s.getPrice()).append(",");
					writer.write(st.toString());
					writer.newLine();
				}
			} else {
				for (ServiceItem s : obj.getServiceItemList()) {
					StringBuilder st = new StringBuilder();
					st.append(s.getId()).append(",");
					st.append(s.getName()).append(",");
					st.append(s.getPrice()).append(",");
					writer.write(st.toString());
					writer.newLine();
				}
			}
			// Move to the next line after writing headers
		} catch (IOException e) {
			System.out.println("Error: Unable to write to the CSV file.");
			e.printStackTrace();
		}
	}
}
