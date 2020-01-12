package coffeemachine.api;

import coffeemachine.model.Order;

public interface DrinkMaker {
    void process(Order order);
}
