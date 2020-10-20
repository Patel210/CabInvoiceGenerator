package com.capgemini.repositoryservice;

import java.util.List; 
import com.capgemini.exception.RepositoryException;
import com.capgemini.exception.RepositoryException.ExceptionType;
import com.capgemini.myride.Ride;
import com.capgemini.repository.RideRepository;

public class RepositoryService {

	private RideRepository rideRepo;

	public RepositoryService() {
		rideRepo = new RideRepository();
	}

	public void addUserRides(int id, List<Ride> rides) {
		rideRepo.getRideRepo().put(id, rides);
	}

	public List<Ride> getUserRides(int id) throws RepositoryException {
		List<Ride> myRides = rideRepo.getRideRepo().get(id);
		if(myRides == null) {
			throw new RepositoryException(ExceptionType.USER_NOT_FOUND);
		}
		return myRides;
	}
}
