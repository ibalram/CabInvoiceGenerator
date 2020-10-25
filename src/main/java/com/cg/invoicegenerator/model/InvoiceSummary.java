package com.cg.invoicegenerator.model;

public class InvoiceSummary {
	public final int noOfRides;
	public final double totalFare;
	private final double averageFare;

	public InvoiceSummary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = totalFare / noOfRides;
	}

	@Override
	public String toString() {
		return "InvoiceSummary [noOfRides=" + noOfRides + ", totalFare=" + totalFare + ", averageFare=" + averageFare
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

}
