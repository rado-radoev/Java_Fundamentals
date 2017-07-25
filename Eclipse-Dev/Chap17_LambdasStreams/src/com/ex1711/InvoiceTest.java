package com.ex1711;

import java.lang.reflect.GenericArrayType;
import java.nio.MappedByteBuffer;
import java.nio.file.attribute.GroupPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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
		
		System.out.printf("%n%-10s%30s%15s%15s%n" ,
				"Part number",
				"Part description",
				"Quantity",
				"Price");
		invoicesList
			.stream()
			.sorted(Comparator.comparing(byPartDescription))

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
		
		
		System.out.println();
		
		System.out.println("Sort by invoice quantity: ");	
		// Map each invoice to its ParDescription and Quantity. Sort results by Quantity. Display results
		Map<Integer, List<String>> sortedByQuantity = 
				invoicesList.stream()
					.collect(Collectors.groupingBy(Invoice::getQuantity, TreeMap::new, Collectors.mapping(Invoice::getPartDescription, Collectors.toList())));
		
		sortedByQuantity.entrySet()
			.stream()
			.forEach(v1 -> {
				System.out.printf("%d ", v1.getKey());
				v1.getValue().forEach(System.out::println);
				});
		
		System.out.println();
		
		System.out.println("Sort by invoice amount: ");
		// Map each invoice to the invoice amount (quantity * pricePerIteam), sort by payed amount and display amount and item description
		Map<Double, List<String>> sortedByPayedAmount =
				invoicesList.stream()
					.collect(Collectors.groupingBy(s -> (s.getQuantity() * s.getPricePerItem()), TreeMap::new,
							Collectors.mapping(Invoice::getPartDescription, Collectors.toList())));
		
		sortedByPayedAmount.entrySet()
			.stream()
			.forEach(v1 -> {
				System.out.printf("%.2f ", v1.getKey());
				v1.getValue().forEach(System.out::println);
			});
		
		System.out.println();
		
		System.out.println("Sort by invoice amount and display range between $200 - $500: ");
		// Map each invoice to the invoice amount (quantity * pricePerIteam), sort by payed amount and display amount and item description 
		// in range 200 - 500
		sortedByPayedAmount.entrySet()
			.stream()
			.filter(w -> (w.getKey() >= 200 && w.getKey() <= 500))
			.forEach(v1 -> {
				System.out.printf("%.2f ", v1.getKey());
				v1.getValue().stream().map(s -> s.toString()).forEach(System.out::println);
			});
		
	}
	
	
	
	
	
	

}
