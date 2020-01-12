package coffeemachine.api.impl;

import coffeemachine.Drink;
import coffeemachine.Order;
import coffeemachine.api.DrinkMaker;
import coffeemachine.api.EmailNotifier;

public class DrinkMakerImpl implements DrinkMaker {

    private final EmailNotifier emailNotifier;

    public DrinkMakerImpl(EmailNotifier emailNotifier) {
        this.emailNotifier = emailNotifier;
    }

    @Override
    public void process(Order order) {
        this.emailNotifier.notifyMissingDrink(Drink.COFFEE);
    }
}
