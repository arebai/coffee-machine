package coffeemachine.api.impl;

import coffeemachine.api.Cashier;
import coffeemachine.model.Drink;
import coffeemachine.model.Money;
import coffeemachine.model.Order;

import java.util.HashMap;
import java.util.Map;

public class CashierImpl implements Cashier {
    private final Map<Drink, Money> priceByDrink;


    public CashierImpl() {
        priceByDrink = new HashMap<Drink, Money>();
        priceByDrink.put(Drink.TEA, new Money(0.4));
        priceByDrink.put(Drink.COFFEE, new Money(0.6));
        priceByDrink.put(Drink.CHOCOLATE, new Money(0.5));
        priceByDrink.put(Drink.JUICE, new Money(0.6));
    }

    public Money computeMissingMoney(Order order) {
        Money drinkPrice = priceByDrink.get(order.getDrink());
        Money money = order.getMoney();
        if (money.isGreaterThan(drinkPrice)) {
            return Money.NONE;
        }

        return new Money(drinkPrice.getAmount() - money.getAmount());
    }


}
