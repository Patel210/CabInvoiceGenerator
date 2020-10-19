package com.capgemini.invoiceservice;

import java.util.List;

import com.capgemini.exception.InvoiceServiceException;
import com.capgemini.exception.InvoiceServiceException.ExceptionType;
import com.capgemini.exception.RepositoryException;
import com.capgemini.myrides.RepositoryService;
import com.capgemini.myrides.Ride;
import com.capgemini.myrides.Ride.ServiceType;

public class CabInvoiceService {

	private final double COST_PER_KM = 10.0;
	private final int COST_PER_MIN = 1;
	private final double MINIMUM_FARE = 5.0;
	private final double COST_PER_KM_PREMIUM = 15.0;
	private final int COST_PER_MIN_PREMIUM = 2;
	private final double MINIMUM_FARE_PREMIUM = 20.0;
	
	private RepositoryService repoService = new RepositoryService();

	public double calculateFare(double distance, int time, ServiceType type) {
		if(type.equals(ServiceType.REGULAR)) {
			return Math.max((COST_PER_KM * distance + COST_PER_MIN * time), MINIMUM_FARE);
		}
		else if(type.equals(ServiceType.PREMIUM)) {
			return Math.max((COST_PER_KM_PREMIUM * distance + COST_PER_MIN_PREMIUM * time), MINIMUM_FARE_PREMIUM);
		}
		return 0;
	}

	public double calculateTotalFare(List<Ride> rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.type);
		}
		return totalFare;
	}

	public InvoiceSummary generateSummary(List<Ride> rides) throws InvoiceServiceException {
		if(rides.size() == 0) {
			throw new InvoiceServiceException(ExceptionType.NO_RIDE_TAKEN);
		}
		double totalFare = calculateTotalFare(rides);
		return new InvoiceSummary(rides.size(), totalFare);
	}
	
	public InvoiceSummary generateSummary(int id) throws InvoiceServiceException, RepositoryException {
		List<Ride> myRides = getRepoService().getUserRides(id);
		if(myRides.size() == 0) {
			throw new InvoiceServiceException(ExceptionType.NO_RIDE_TAKEN);
		}
		double totalFare = calculateTotalFare(myRides);
		return new InvoiceSummary(myRides.size(), totalFare);
	}
	
	public RepositoryService getRepoService() {
		return repoService;
	}
}
