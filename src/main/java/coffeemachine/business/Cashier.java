package coffeemachine.business;

import coffeemachine.Drink;

public class Cashier {
    public Money checkout(Drink drink, Money money) {
        double drinkPrice = drink == Drink.TEA ? 0.4 : 0.6;
        return new Money(drinkPrice - money.getAmount());
    }
}
