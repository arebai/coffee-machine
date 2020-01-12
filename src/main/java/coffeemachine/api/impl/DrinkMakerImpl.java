package coffeemachine.api.impl;

import coffeemachine.Drink;
import coffeemachine.Order;
import coffeemachine.api.BeverageQuantityChecker;
import coffeemachine.api.DrinkMaker;
import coffeemachine.api.EmailNotifier;

public class DrinkMakerImpl implements DrinkMaker {

    private final BeverageQuantityChecker beverageQuantityChecker;
    private final EmailNotifier emailNotifier;

    public DrinkMakerImpl(BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    @Override
    public void process(Order order) {
        this.beverageQuantityChecker.isEmpty(Drink.COFFEE);
        this.emailNotifier.notifyMissingDrink(Drink.COFFEE);
    }
}
