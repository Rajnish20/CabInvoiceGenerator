package com.magic.invoicegenerator;

import com.magic.invoicegenerator.entity.InvoiceSummary;
import com.magic.invoicegenerator.entity.Ride;
import com.magic.invoicegenerator.service.InvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InvoiceGeneratorTest {

    @Test
    public void givenTimeAndDistance_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 5;
        int time = 20;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(70, fare);
    }

    @Test
    public void givenLessTimeAndDistance_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(5, 20),
                new Ride(0.1, 1)};
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 75);
        InvoiceSummary summary = invoiceGenerator.calculateFare(Arrays.asList(rides));
        Assertions.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(5, 20),
                new Ride(0.1, 1)};
        Integer userId = 1;
        invoiceGenerator.addInRideRepository(1, Arrays.asList(rides));
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 75);
        InvoiceSummary summary = invoiceGenerator.calculateFare(1);
        Assertions.assertEquals(expectedSummary, summary);
    }
}
