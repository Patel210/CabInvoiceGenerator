package com.capgemini.myride;

public class Ride {
	
	public ServiceType type;
	private double distance;
	private int time;
	private double fare;

	public Ride(double distance, int time, ServiceType type) {
		this.distance = distance;
		this.time = time;
		this.type = type;
		this.fare = this.calculateRideFare();
	}

	private double calculateRideFare() {
		return Math.max((this.distance * type.getCostPerKm() + this.time * type.getCostPerMin()), type.getMinimumFare());
	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}

	public double getFare() {
		return fare;
	}
}
