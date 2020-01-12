package coffeemachine.management;

import coffeemachine.business.Money;
import coffeemachine.model.Drink;

import java.util.Map;

public class Report {
    private final Map<Drink, Long> countByDrink;
    private final Money totalEarned;

    public Report(Map<Drink, Long> countByDrink, Money totalEarned) {
        this.countByDrink = countByDrink;
        this.totalEarned = totalEarned;
    }

    public Map<Drink, Long> getCountByDrink() {
        return countByDrink;
    }

    public Money getTotalEarned() {
        return totalEarned;
    }
}
