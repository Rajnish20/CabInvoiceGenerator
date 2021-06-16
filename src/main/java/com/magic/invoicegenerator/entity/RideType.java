package com.magic.invoicegenerator.entity;

public enum RideType {
    NORMAL(10, 1, 5),
    PREMIUM(15, 2, 20);

    public double costPerKm;
    public int costPerMin;
    public int minimumFare;

    RideType(double costPerKm, int costPerMin, int minimumFare) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minimumFare = minimumFare;

    }

    public double totalFare(double distance, int time) {
        return Math.max(this.minimumFare, distance * this.costPerKm + time * this.costPerMin);
    }
}
