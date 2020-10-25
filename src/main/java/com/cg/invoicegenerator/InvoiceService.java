package com.cg.invoicegenerator;

import com.cg.invoicegenerator.model.InvoiceSummary;
import com.cg.invoicegenerator.model.Ride;
import com.cg.invoicegenerator.model.RideRepository;

public class InvoiceService {
	private static final int MINIMUM_COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final int MINIMUM_FARE = 5;
	private RideRepository rideRepository;

	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, totalFare);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));

	}

}
