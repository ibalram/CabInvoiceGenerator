package com.cg.invoicegenerator.model;

public class Ride {
	private double distance;
	private int time;
	private CabRide rideType;

	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	public Ride(CabRide rideType, double distance, int time) {
		this.rideType = rideType;
		this.distance = distance;
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public double getRideCost() {
		return rideType.calcCostPerRide(this);
	}
}
