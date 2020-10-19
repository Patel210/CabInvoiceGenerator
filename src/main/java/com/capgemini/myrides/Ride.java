package com.capgemini.myrides;

public class Ride {
	
	public ServiceType type;
	private double distance;
	private int time;
	
	public enum ServiceType{
		REGULAR, PREMIUM;
	}

	public Ride(double distance, int time, ServiceType type) {
		this.distance = distance;
		this.time = time;
		this.type = type;
	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
}
