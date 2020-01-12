package coffeemachine.api;

import coffeemachine.model.Drink;

public interface EmailNotifier {
    void notifyMissingDrink(Drink drink);
}
