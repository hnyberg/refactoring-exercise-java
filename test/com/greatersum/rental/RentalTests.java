package com.greatersum.rental;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Arrays;

public class RentalTests {
    @Test
    public void MartinTest() {
        MovieRepository movieRepo = new MovieRepository();
        Customer customerMartin = new Customer(
                "martin",
                Arrays.asList(
                        new MovieRental("F001", 3),
                        new MovieRental("F002", 1)));
        String customerStatement = movieRepo.getStatementForCustomer(customerMartin);
        Approvals.verify(customerStatement);
    }
}
