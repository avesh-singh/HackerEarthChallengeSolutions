package com.CallHealth_Challenge;

import java.util.Comparator;

public class Customer implements Comparator {
	int ID;
	double bill;
	boolean voucher;

	public Customer(int iD, double bill, boolean v) {
		ID = iD;
		this.bill = bill;
		voucher = v;
	}

	@Override
	public boolean equals(Object obj) {
		// if (this == obj)
		// return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (ID != other.ID)
			return false;
		// if (Double.doubleToLongBits(bill) != Double
		// .doubleToLongBits(other.bill))
		// return false;
		return true;
	}

	public int compare(Object arg0, Object arg1) {
		Customer c1 = (Customer) arg0;
		Customer c2 = (Customer) arg1;
		if (c2.bill == c1.bill) {
			return (int) (c2.ID - c1.ID);
		} else
			return (int) (c2.bill - c1.bill);
	}

	@Override
	public String toString() {
		return ID + " " + String.format("%.2f", bill);
	}

}
