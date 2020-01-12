package coffeemachine.api;

import coffeemachine.Drink;

public interface EmailNotifier {
    void notifyMissingDrink(Drink drink);
}
