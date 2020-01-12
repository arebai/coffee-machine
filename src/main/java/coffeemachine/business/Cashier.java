package coffeemachine.business;

import coffeemachine.Drink;

public class Cashier {
    public Money checkout(Drink drink, Money money) {
        return new Money(0.1);
    }
}
