package coffeemachine.management;

import coffeemachine.model.Drink;

import java.util.Collection;

public interface OrderRepository {
    Collection<Drink> getDailyDrinks();
}
