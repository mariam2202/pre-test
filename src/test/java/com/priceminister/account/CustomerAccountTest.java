package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * <p>
 * We want to see how you "think code", and how you organize and structure a simple application.
 * <p>
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 */
public class CustomerAccountTest {

    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        // Given

        // When
        Double total = customerAccount.getBalance();

        // Then
        Assert.assertNotNull("The total shouldn't be null", total);
        Assert.assertEquals("The total should be equal to 0", 0D, total, 0.001D);
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        // Given
        customerAccount.add(100D);

        // When
        Double total = customerAccount.getBalance();

        // Then
        Assert.assertEquals(100D, total, 0.001d);
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
        // Given
        rule = new CustomerAccountRule();
        customerAccount.add(25D);
        try {
            // When
            customerAccount.withdrawAndReportBalance(30D, rule);
            Assert.fail("The account shouln't be decrease");
        } catch (IllegalBalanceException e) {
            // Then
            Assert.assertEquals(25D, customerAccount.getBalance(), 0.001d);
        }
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testSimpleWithdraw() throws IllegalBalanceException {
        // Given
        rule = new CustomerAccountRule();
        customerAccount.add(50D);

        // When
        Double total = customerAccount.withdrawAndReportBalance(30D, rule);

        // Then
        Assert.assertEquals(20D, total, 0.001d);
    }

    // Also implement missing unit tests for the above functionalities.

}
