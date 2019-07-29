package com.astoudcommerce.task2.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class StringTest {

	@Test
	public void printAllUncompletedTask() {
		String data="product1: 12.50$; product2: 13$; product3: 1 598.00$";
		String[] items = data.replaceAll("product[0-9]: |;| ", "").split("[$]");
		List<Double> itemList=new ArrayList<Double>();
		for (String string : items) {
			itemList.add(Double.parseDouble(string)+1);
		}
		
		for (Double price : itemList) {
			System.out.println(price + "$");
		}
	}

}
