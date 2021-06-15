package com.magic.invoicegenerator.service;

import com.magic.invoicegenerator.entity.InvoiceSummary;
import com.magic.invoicegenerator.entity.Ride;
import com.magic.invoicegenerator.entity.RideRepository;

import java.util.List;

public class InvoiceGenerator {
    private static final double COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time) {
        return Math.max(MINIMUM_FARE, distance * COST_PER_KM + time * COST_PER_MINUTE);
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public InvoiceSummary calculateFare(Integer userId) {
        return calculateFare(this.rideRepository.getList(userId));
    }

    public void addInRideRepository(Integer userId, List<Ride> rideList) {
        rideRepository.add(userId, rideList);
    }
}
