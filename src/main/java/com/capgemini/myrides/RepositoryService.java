package com.capgemini.myrides;

import java.util.List;

import com.capgemini.exception.InvoiceServiceException;
import com.capgemini.exception.InvoiceServiceException.ExceptionType;

public class RepositoryService {
	
	private RideRepository rideRepo;

	public RepositoryService() {
		rideRepo = new RideRepository();
	}

	public void addUserRides(int id, List<Ride> rides) {
		rideRepo.getRideRepo().put(id, rides);
	}

	public List<Ride> getUserRides(int id) throws InvoiceServiceException {
		List<Ride> myRides = rideRepo.getRideRepo().get(id);
		if (myRides.size() == 0) {
			throw new InvoiceServiceException(ExceptionType.NO_RIDE);
		}
		return myRides;
	}
}
