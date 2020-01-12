package coffeemachine.management;

import coffeemachine.Drink;

import java.util.Collection;

public interface OrderRepository {
    Collection<Drink> getDailyDrinks();
}
