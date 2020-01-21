package coffeemachine.api;

import coffeemachine.model.Money;
import coffeemachine.model.Order;

public interface Cashier {
    Money computeMissingMoney(Order order);
}
