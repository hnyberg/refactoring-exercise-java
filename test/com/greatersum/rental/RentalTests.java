package com.greatersum.rental;

import com.greatersum.rental.model.Customer;
import com.greatersum.rental.model.MovieRental;
import com.greatersum.rental.services.StatementService;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Arrays;

public class RentalTests {
    @Test
    public void MartinTest() {
        Customer customerMartin = new Customer(
                "martin",
                Arrays.asList(
                        new MovieRental("F001", 3),
                        new MovieRental("F002", 1)));
        String customerStatement = StatementService.getStatementForCustomer(customerMartin);
        Approvals.verify(customerStatement);
    }
}
