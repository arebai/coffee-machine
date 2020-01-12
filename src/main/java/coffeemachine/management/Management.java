package coffeemachine.management;

import coffeemachine.Drink;
import coffeemachine.business.Money;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Management {

    private OrderRepository orderRepository;

    public Management(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Report generate() {
        Collection<Drink> drinks = orderRepository.getDailyDrinks();
        Map<Drink, Long> countByDrink = getCountByDrink(drinks);
        return new Report(countByDrink, new Money(0.4));
    }

    private Map<Drink, Long> getCountByDrink(Collection<Drink> drinks) {
        return drinks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
