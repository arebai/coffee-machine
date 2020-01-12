package coffeemachine.api;

import coffeemachine.Order;

public interface DrinkMaker {
    void process(Order order);
}
