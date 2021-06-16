package com.magic.invoicegenerator;

import com.magic.invoicegenerator.entity.InvoiceSummary;
import com.magic.invoicegenerator.entity.Ride;
import com.magic.invoicegenerator.entity.RideType;
import com.magic.invoicegenerator.service.InvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InvoiceGeneratorTest {

    @Test
    public void givenTimeAndDistanceForNormal_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 5;
        int time = 20;
        double fare = invoiceGenerator.calculateFare(distance, time, RideType.NORMAL);
        Assertions.assertEquals(70, fare);
    }

    @Test
    public void givenLessTimeAndDistanceForNormal_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time, RideType.NORMAL);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenTimeAndDistanceForPremium_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 5;
        int time = 20;
        double fare = invoiceGenerator.calculateFare(distance, time, RideType.PREMIUM);
        Assertions.assertEquals(115, fare);
    }

    @Test
    public void givenLessTimeAndDistanceForPremium_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time, RideType.PREMIUM);
        Assertions.assertEquals(20, fare);
    }


    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(5, 20, RideType.NORMAL),
                new Ride(0.1, 1, RideType.NORMAL),
                new Ride(10, 15, RideType.PREMIUM)};
        InvoiceSummary expectedSummary = new InvoiceSummary(3, 255);
        InvoiceSummary summary = invoiceGenerator.calculateFare(Arrays.asList(rides));
        Assertions.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(5, 20, RideType.NORMAL),
                new Ride(0.1, 1, RideType.PREMIUM)};
        Integer userId = 1;
        invoiceGenerator.addInRideRepository(1, Arrays.asList(rides));
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 90);
        InvoiceSummary summary = invoiceGenerator.calculateFare(1);
        Assertions.assertEquals(expectedSummary, summary);
    }
}
