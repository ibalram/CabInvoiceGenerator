package com.cg.invoicegenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.invoicegenerator.model.CabRide;
import com.cg.invoicegenerator.model.InvoiceSummary;
import com.cg.invoicegenerator.model.Ride;
import com.cg.invoicegenerator.model.RideRepository;

public class AppTest {
	private InvoiceService invoiceService;

	@Before
	public void initialise() {
		invoiceService = new InvoiceService();
		RideRepository rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "balram@cg.com";
		Ride[] rides = { new Ride(CabRide.NORMAL, 2.0, 5), new Ride(CabRide.PREMIUM, 0.1, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary actualSummary = new InvoiceSummary(2, 45.0);
		assertEquals(actualSummary, summary);
	}
}
