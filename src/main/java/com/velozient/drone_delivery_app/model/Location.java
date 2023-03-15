package com.velozient.drone_delivery_app.model;

public class Location implements Comparable<Location> {

	private String name;
	private Double deliveryWeight;
	
	public Location(String name, Double deliveryWeight) {
		this.name = name;
		this.deliveryWeight = deliveryWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDeliveryWeight() {
		return deliveryWeight;
	}

	public void setDeliveryWeight(Double deliveryWeight) {
		this.deliveryWeight = deliveryWeight;
	}
	
	
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Location other = (Location) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

	@Override
	public int compareTo(Location outraLocation) {
		if (this.deliveryWeight < outraLocation.getDeliveryWeight()) {
			return -1;
		}
		if (this.deliveryWeight > outraLocation.getDeliveryWeight()) {
			return 1;
		}
		return 0;
	}

}
