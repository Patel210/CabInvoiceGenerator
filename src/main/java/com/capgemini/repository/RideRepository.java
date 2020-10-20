package com.capgemini.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.myride.Ride;

public class RideRepository {
	
	private Map<Integer, List<Ride>> rideRepo;

	public RideRepository() {
		this.rideRepo = new HashMap<Integer, List<Ride>>();
	}

	public Map<Integer, List<Ride>> getRideRepo() {
		return rideRepo;
	}

	public void setRideRepo(Map<Integer, List<Ride>> rideRepo) {
		this.rideRepo = rideRepo;
	}
}
