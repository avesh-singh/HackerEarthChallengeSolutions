package com.CallHealth_Challenge;

import java.util.LinkedList;
import java.util.List;

public class Bills {
	private List<Customer> customers = new LinkedList<Customer>();
	private List<Item> inventory = new LinkedList<Item>();
	private int A;

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public boolean customerExists(int id) {
		return customers.contains(new Customer(id, 0, false));
	}

	public Item getItem(String name) {
		return inventory.get(itemIndex(name));
	}

	public Customer getCustomer(int id, String voucher) {
		if (customerExists(id)) {
			return customers.get(index(id));
		} else {
			boolean v = false;
			if (voucher.toLowerCase().equals("yes")) {
				v = true;
			}
			Customer newCust = new Customer(id, 0, v);
			customers.add(newCust);
			return newCust;
		}
	}

	public int index(int id) {
		return customers.indexOf(new Customer(id, 0, false));
	}

	public int itemIndex(String name) {
		return inventory.indexOf(new Item(name, 0));
	}

	public void addAmount(int id, String item, int q, int amt, String voucher) {
		Customer c = getCustomer(id, voucher);
		Item i = getItem(item);
		c.bill += amt * q * (1 - i.discount / 100.00);
	}

	public void getBills() {
		Customer c = customers.get(0);
		for (int i = 0; i < customers.size(); i++) {
			c = customers.get(i);
			if (c.voucher)
				c.bill -= A;
		}
		customers.sort(c);
		for (int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i));
		}
	}

}
