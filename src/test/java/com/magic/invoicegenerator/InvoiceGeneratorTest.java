package com.magic.invoicegenerator;

import com.magic.invoicegenerator.service.InvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    @Test
    public void dummy() {
        System.out.println("Welcome to Invoice Generator");
    }

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
}
