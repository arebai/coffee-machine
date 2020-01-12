package coffeemachine.management;

import coffeemachine.Drink;
import coffeemachine.business.Money;

import java.util.Map;

public class Report {
    private final Map<Drink, Integer> countByDrink;
    private final Money totalEarned;

    public Report(Map<Drink, Integer> countByDrink, Money totalEarned) {
        this.countByDrink = countByDrink;
        this.totalEarned = totalEarned;
    }

    public Map<Drink, Integer> getCountByDrink() {
        return countByDrink;
    }

    public Money getTotalEarned() {
        return totalEarned;
    }
}
