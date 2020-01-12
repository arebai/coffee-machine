package coffeemachine.api;

import coffeemachine.model.Drink;

public interface BeverageQuantityChecker {
    boolean isEmpty(Drink drink);
}
