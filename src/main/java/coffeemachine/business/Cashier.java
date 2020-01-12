package coffeemachine.business;

import coffeemachine.Drink;

public class Cashier {
    public Money checkout(Drink drink, Money money) {
        double teaPrice = 0.4;
        return new Money(teaPrice - money.getAmount());
    }
}
