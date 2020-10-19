package com.capgemini.myrides;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
	
	private Map<Integer, List<Ride>> rideRepo;

	public RideRepository() {
		setRideRepo(new HashMap<Integer, List<Ride>>());
	}

	public Map<Integer, List<Ride>> getRideRepo() {
		return rideRepo;
	}

	public void setRideRepo(Map<Integer, List<Ride>> rideRepo) {
		this.rideRepo = rideRepo;
	}
}
