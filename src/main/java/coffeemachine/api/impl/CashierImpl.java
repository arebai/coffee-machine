package coffeemachine.api.impl;

import coffeemachine.api.Cashier;
import coffeemachine.model.Money;
import coffeemachine.model.Order;

public class CashierImpl implements Cashier {
    public Money computeMissingMoney(Order order) {
        double teaPrice = 0.4;
        Money money = order.getMoney();
        if (money.getAmount() > teaPrice) {
            return Money.NONE;
        }
        return new Money(teaPrice - money.getAmount());
    }
}
