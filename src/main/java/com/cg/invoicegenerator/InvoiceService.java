package com.cg.invoicegenerator;

public class InvoiceService {
	private static final int MINIMUM_COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final int MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, totalFare);
	}

}
