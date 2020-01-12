package coffeemachine.business;

import coffeemachine.model.Drink;

public class Cashier {

    private Menu menu;

    public Cashier(Menu menu) {
        this.menu = menu;
    }

    public Money computeMissingMoney(Drink drink, Money money) {
        Money drinkPrice = menu.getPrice(drink);
        if (money.isGreaterThan(drinkPrice)) {
            return Money.NONE;
        }
        return new Money(drinkPrice.getAmount() - money.getAmount());
    }


}
