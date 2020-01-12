package coffeemachine.business;

import coffeemachine.model.Drink;

public interface Menu {
    Money getPrice(Drink drink);
}
