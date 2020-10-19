package com.capgemini.invoiceservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
}
