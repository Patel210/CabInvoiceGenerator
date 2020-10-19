package com.capgemini.invoiceservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.myrides.Ride;

public class InvoiceServiceTest {

	CabInvoiceService cabInvoiceService;

	@Before
	public void setUp() {
		cabInvoiceService = new CabInvoiceService();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTheFare() {
		double distance = 5.0;
		int time = 10;
		double fare = cabInvoiceService.calculateFare(distance, time);
		assertEquals(60.0, fare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_BelowMinimumFareThresholdCondition_ShouldReturnTheMinimumFare() {
		double distance = 0.3;
		int time = 1;
		double fare = cabInvoiceService.calculateFare(distance, time);
		assertEquals(5.0, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldCalculateTotalFare() {
		Ride[] rides = { new Ride(5.0, 10), new Ride(0.3, 1), new Ride(10.0, 20) };
		double fare = cabInvoiceService.calculateTotalFare(rides);
		assertEquals(185.0, fare, 0.0);
	}
}
