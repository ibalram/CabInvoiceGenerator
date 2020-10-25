package com.cg.invoicegenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		double totalFare = invoiceService.calculateFare(rides);
		assertEquals(30.0, totalFare, 0.0);
	}
}
