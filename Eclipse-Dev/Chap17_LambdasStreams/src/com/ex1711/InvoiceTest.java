package com.ex1711;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.function.Function;

public class InvoiceTest {

	public static void main(String[] args) {
		
		Invoice[] invoices = {
				new Invoice(83, "Electric Sander", 7, 57.98),
				new Invoice(24, "Power saw", 18, 99.99),
				new Invoice(7, "Sledge hammer", 11, 21.50),
				new Invoice(77, "Hammer", 76, 11.99),
				new Invoice(39, "Lawn mower", 3, 79.50),
				new Invoice(68, "Screwdriver", 106, 6.99),
				new Invoice(56, "Jig saw", 21, 11.00),
				new Invoice(3, "Wrench", 34, 7.50)};
		
<<<<<<< HEAD
		// Convert invoices array to List and display the unmodified list
		List<Invoice> invoicesList = Arrays.asList(invoices);
		System.out.printf("List of invoices (unmodified):%n");
		int counter = 0;
		while (invoicesList.iterator().hasNext() && counter < invoicesList.size()) {
			System.out.println(invoicesList.get(counter));
			counter++;
		}
		
		System.out.println();
		
		// Sort invoice objects by Part Description and display them
		Function<Invoice, String> byPartDescription = Invoice::getPartDescription;
		System.out.printf("Invoice objects sorted by Part Description:");
=======
		
		List<Invoice> invoicesList = Arrays.asList(invoices);
		System.out.printf("List of invoices (unmodified):%n");
		System.out.printf("%s%n", invoicesList);
		
		
		
		// Sort invoice objects by Part Description and display them
		Function<Invoice, String> byPartDescription = Invoice::getPartDescription;
		System.out.printf("Invoice objects sorted by Part Description");
>>>>>>> e59cc6c2afe59ac8f5f973cc3627a9c2c440ada4
		System.out.printf("%n%-10s%30s%15s%15s%n" ,
				"Part number",
				"Part description",
				"Quantity",
				"Price");
		invoicesList
			.stream()
			.sorted(Comparator.comparing(byPartDescription))
<<<<<<< HEAD
			.forEach(item -> System.out.printf("%-10s%30s%15d%15.2f%n", 
					item.getPartNumber(),
					item.getPartDescription(),
					item.getQuantity(),
					item.getPricePerItem()));
		
		System.out.println();
		
		// Sort invoice objects by Price, from hight to low and then by part Number
		System.out.printf("Invoice objects sorted by Price:");
		System.out.printf("%n%-10s%30s%15s%15s%n" ,
				"Part number",
				"Part description",
				"Quantity",
				"Price");
		invoicesList
			.stream()
			.sorted(Comparator.comparing(Invoice::getPricePerItem).reversed().thenComparing(Invoice::getPartNumber))
			.forEach(System.out::println);
=======
			.forEach(System.out::println);
		
>>>>>>> e59cc6c2afe59ac8f5f973cc3627a9c2c440ada4
	}
	
	

}
