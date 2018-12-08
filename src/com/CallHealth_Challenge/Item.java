package com.CallHealth_Challenge;

public class Item {
	String name;
	double discount;

	public Item(String name, double discount) {
		this.name = name;
		this.discount = discount;
	}

	@Override
	public boolean equals(Object obj) {
		// if (this == obj)
		// return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		// if (Double.doubleToLongBits(discount) != Double
		// .doubleToLongBits(other.discount))
		// return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " " + discount;
	}
}
