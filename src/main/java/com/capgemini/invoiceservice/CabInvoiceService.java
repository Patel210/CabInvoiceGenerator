package com.capgemini.invoiceservice;

public class CabInvoiceService {

	private final double COST_PER_KM = 10.0;
	private final int COST_PER_MIN = 1;
	private final double MINIMUM_FARE = 5.0;

	public double calculateFare(double distance, int time) {
		return Math.max((COST_PER_KM * distance + COST_PER_MIN * time), MINIMUM_FARE);
	}
}
