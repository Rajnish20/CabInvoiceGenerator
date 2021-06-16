package com.magic.invoicegenerator.service;

import com.magic.invoicegenerator.entity.InvoiceSummary;
import com.magic.invoicegenerator.entity.Ride;
import com.magic.invoicegenerator.entity.RideRepository;
import com.magic.invoicegenerator.entity.RideType;

import java.util.List;

public class InvoiceGenerator {

    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time, RideType type) {
        return type.totalFare(distance, time);
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time, ride.type);
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
