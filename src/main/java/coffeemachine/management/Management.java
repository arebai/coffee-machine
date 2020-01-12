package coffeemachine.management;

import coffeemachine.Drink;
import coffeemachine.business.Money;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Management {


    public Report generate() {
        Collection<Drink> drinks = getDailyDrinks();
        Map<Drink, Long> countByDrink = getCountByDrink(drinks);
        return new Report(countByDrink, new Money(0.4));
    }

    private Collection<Drink> getDailyDrinks() {
        return Collections.singletonList(Drink.TEA);
    }

    private Map<Drink, Long> getCountByDrink(Collection<Drink> drinks) {
        return drinks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
