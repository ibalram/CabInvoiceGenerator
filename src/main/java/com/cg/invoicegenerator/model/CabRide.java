package com.cg.invoicegenerator.model;

public enum CabRide {
	NORMAL(10.0, 1.0, 5.0), PREMIUM(15.0, 2.0, 20.0);

	private final double costPerKm;
	private final double costPerMin;
	private final double minFare;

	CabRide(double costPerKm, double costPerMin, double minFare) {
		this.costPerKm = costPerKm;
		this.costPerMin = costPerMin;
		this.minFare = minFare;
	}

	public double calcCostPerRide(Ride ride) {
		double totalFare = ride.getDistance() * costPerKm + ride.getTime() * costPerMin;
		return Math.max(minFare, totalFare);
	}
}
