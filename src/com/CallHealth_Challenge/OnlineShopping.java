package com.CallHealth_Challenge;

import java.util.List;
import java.util.Scanner;

public class OnlineShopping {

	/*
	 * given customerIds, items, quantities and price of one quantity print the
	 * bills of the customers
	 */

	// 3
	// clothes 20
	// electronics 50
	// groceries 50
	// 100
	// 4
	// 1 clothes 1 600 YES
	// 3 electronics 2 5000 NO
	// 1 groceries 1 200 YES
	// 2 clothes 2 500 NO
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Bills bills = new Bills();
		List<Item> inventory = bills.getInventory();
		for (int i = 0; i < N; i++) {
			String input = scan.next();
			String dis = scan.next();
			inventory.add(new Item(input, Double.parseDouble(dis)));
		}
		bills.setA(scan.nextInt());
		int M = scan.nextInt();
		for (int i = 0; i < M; i++) {
			bills.addAmount(scan.nextInt(), scan.next().toLowerCase().trim(),
					scan.nextInt(), scan.nextInt(), scan.next().toLowerCase());
		}
		bills.getBills();
		scan.close();
	}
}
