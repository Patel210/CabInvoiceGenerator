package com.capgemini.myrides;

public class Ride {

	private double distance;
	private int time;

	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
}
