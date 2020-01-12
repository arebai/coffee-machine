package coffeemachine.business;

import coffeemachine.Drink;

public interface Menu {
    Money getPrice(Drink drink);
}
