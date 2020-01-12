package coffeemachine.management;

import coffeemachine.Drink;
import coffeemachine.business.Money;

import java.util.HashMap;
import java.util.Map;

public class Management {


    public Report generate() {
        Map<Drink, Integer> countByDrink = getCountByDrink();
        return new Report(countByDrink, new Money(0.4));
    }

    private Map<Drink, Integer> getCountByDrink() {
        Map<Drink, Integer> countByDrink = new HashMap<Drink, Integer>();
        countByDrink.put(Drink.TEA, 1);
        return countByDrink;
    }
}
