package com.cg.invoicegenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.invoicegenerator.model.InvoiceSummary;
import com.cg.invoicegenerator.model.Ride;

public class AppTest {
	private InvoiceService invoiceService;

	@Before
	public void initialise() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary actualSummary = new InvoiceSummary(2, 30.0);
		assertEquals(actualSummary, summary);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "balram@cg.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary actualSummary = new InvoiceSummary(2, 30.0);
		assertEquals(actualSummary, summary);
	}
}
