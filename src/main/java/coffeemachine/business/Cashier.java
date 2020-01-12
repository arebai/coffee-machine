package coffeemachine.business;

import coffeemachine.Drink;

import java.util.HashMap;
import java.util.Map;

public class Cashier {

    public Money checkout(Drink drink, Money money) {
        Map<Drink, Money> priceByDrink = getDrinksPrice();
        Money drinkPrice = priceByDrink.get(drink);
        return new Money(drinkPrice.getAmount() - money.getAmount());
    }

    private Map<Drink, Money> getDrinksPrice() {
        Map<Drink, Money> priceByDrink = new HashMap<Drink, Money>();
        priceByDrink.put(Drink.TEA, new Money(0.4));
        priceByDrink.put(Drink.COFFEE, new Money(0.6));
        return priceByDrink;
    }
}
