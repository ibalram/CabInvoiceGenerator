package com.cg.invoicegenerator;

import com.cg.invoicegenerator.model.InvoiceSummary;
import com.cg.invoicegenerator.model.Ride;
import com.cg.invoicegenerator.model.RideRepository;

public class InvoiceService {
	private RideRepository rideRepository;

	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += ride.getRideCost();
		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));

	}

}
