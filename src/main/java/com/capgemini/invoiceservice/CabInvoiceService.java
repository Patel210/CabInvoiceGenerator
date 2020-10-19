package com.capgemini.invoiceservice;

import com.capgemini.exception.InvoiceServiceException;
import com.capgemini.exception.InvoiceServiceException.ExceptionType;
import com.capgemini.myrides.Ride;

public class CabInvoiceService {

	private final double COST_PER_KM = 10.0;
	private final int COST_PER_MIN = 1;
	private final double MINIMUM_FARE = 5.0;

	public double calculateFare(double distance, int time) {
		return Math.max((COST_PER_KM * distance + COST_PER_MIN * time), MINIMUM_FARE);
	}

	public double calculateTotalFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	public InvoiceSummary generateSummary(Ride[] rides) throws InvoiceServiceException {
		if(rides.length == 0) {
			throw new InvoiceServiceException(ExceptionType.NO_RIDE);
		}
		double totalFare = calculateTotalFare(rides);
		return new InvoiceSummary(rides.length, totalFare);
	}
}
