package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance = 0D;

    public void add(Double addedAmount) {
        balance += addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException {
        if (withdrawnAmount == null) {
            throw new IllegalBalanceException(null);
        }
        Double newBalance = balance - withdrawnAmount;
        if (!rule.withdrawPermitted(newBalance)) {
            throw new IllegalBalanceException(newBalance);
        }
        return balance = newBalance;
    }
}
