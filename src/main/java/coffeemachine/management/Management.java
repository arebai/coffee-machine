package coffeemachine.management;

import coffeemachine.business.Menu;
import coffeemachine.business.Money;
import coffeemachine.model.Drink;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Management {

    private OrderRepository orderRepository;
    private Menu menu;

    public Management(OrderRepository orderRepository, Menu menu) {
        this.orderRepository = orderRepository;
        this.menu = menu;
    }

    public Report generate() {
        Collection<Drink> drinks = orderRepository.getDailyDrinks();
        Map<Drink, Long> countByDrink = getCountByDrink(drinks);
        return new Report(countByDrink, getTotalEarned(countByDrink));
    }

    private Money getTotalEarned(Map<Drink, Long> countByDrink) {
        double totalEarned = countByDrink.entrySet()
                .stream()
                .map(drinkCountEntry -> getEarnedForDrink(drinkCountEntry.getKey(), drinkCountEntry.getValue()))
                .mapToDouble(Money::getAmount).sum();
        return new Money(totalEarned);
    }

    private Money getEarnedForDrink(Drink drink, Long orderCount) {
        Money price = menu.getPrice(drink);
        return new Money(orderCount * price.getAmount());
    }

    private Map<Drink, Long> getCountByDrink(Collection<Drink> drinks) {
        return drinks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
