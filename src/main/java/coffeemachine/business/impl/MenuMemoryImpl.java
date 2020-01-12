package coffeemachine.business.impl;

import coffeemachine.Drink;
import coffeemachine.business.Menu;
import coffeemachine.business.Money;

import java.util.HashMap;
import java.util.Map;

public class MenuMemoryImpl implements Menu {

    private final Map<Drink, Money> priceByDrink;

    public MenuMemoryImpl() {
        priceByDrink = new HashMap<Drink, Money>();
        priceByDrink.put(Drink.TEA, new Money(0.4));
        priceByDrink.put(Drink.COFFEE, new Money(0.6));
        priceByDrink.put(Drink.CHOCOLATE, new Money(0.5));
    }


    public Money getPrice(Drink drink) {
        return priceByDrink.get(drink);
    }
}
