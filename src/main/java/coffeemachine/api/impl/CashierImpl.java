package coffeemachine.api.impl;

import coffeemachine.api.Cashier;
import coffeemachine.model.Money;
import coffeemachine.model.Order;

public class CashierImpl implements Cashier {
    public Money computeMissingMoney(Order order) {
        return new Money(0.3);
    }
}
