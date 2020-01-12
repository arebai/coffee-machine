package coffeemachine.api.impl;

import coffeemachine.api.BeverageQuantityChecker;
import coffeemachine.api.DrinkMaker;
import coffeemachine.api.EmailNotifier;
import coffeemachine.model.Drink;
import coffeemachine.model.Order;

public class DrinkMakerImpl implements DrinkMaker {

    private final BeverageQuantityChecker beverageQuantityChecker;
    private final EmailNotifier emailNotifier;

    public DrinkMakerImpl(BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    @Override
    public void process(Order order) {
        Drink drink = order.getDrink();
        if (this.beverageQuantityChecker.isEmpty(drink)) {
            this.emailNotifier.notifyMissingDrink(drink);
        }
    }
}
