package com.capgemini.myride;

public enum ServiceType {
	REGULAR(10.0, 1.0, 5.0), PREMIUM(15.0, 2.0, 20.0);

	private final double costPerKm;
	private final double costPerMin;
	private final double minimumFare;

	ServiceType(double costPerKm, double costPerMin, double minimumFare) {
		this.costPerKm = costPerKm;
		this.costPerMin = costPerMin;
		this.minimumFare = minimumFare;
	}

	public double getCostPerKm() {
		return costPerKm;
	}

	public double getCostPerMin() {
		return costPerMin;
	}

	public double getMinimumFare() {
		return minimumFare;
	}
}
