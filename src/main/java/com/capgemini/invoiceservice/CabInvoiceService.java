package com.capgemini.invoiceservice;

import java.util.List;

import com.capgemini.exception.InvoiceServiceException;
import com.capgemini.exception.InvoiceServiceException.ExceptionType;
import com.capgemini.myrides.RepositoryService;
import com.capgemini.myrides.Ride;

public class CabInvoiceService {

	private final double COST_PER_KM = 10.0;
	private final int COST_PER_MIN = 1;
	private final double MINIMUM_FARE = 5.0;
	private RepositoryService repoService = new RepositoryService();

	public double calculateFare(double distance, int time) {
		return Math.max((COST_PER_KM * distance + COST_PER_MIN * time), MINIMUM_FARE);
	}

	public double calculateTotalFare(List<Ride> rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	public InvoiceSummary generateSummary(List<Ride> rides) throws InvoiceServiceException {
		if(rides.size() == 0) {
			throw new InvoiceServiceException(ExceptionType.NO_RIDE);
		}
		double totalFare = calculateTotalFare(rides);
		return new InvoiceSummary(rides.size(), totalFare);
	}
	
	public InvoiceSummary generateSummary(int id) throws InvoiceServiceException {
		List<Ride> myRides = getRepoService().getUserRides(id);
		double totalFare = calculateTotalFare(myRides);
		return new InvoiceSummary(myRides.size(), totalFare);
	}

	public RepositoryService getRepoService() {
		return repoService;
	}
}
