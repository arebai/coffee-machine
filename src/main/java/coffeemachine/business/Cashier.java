package coffeemachine.business;

import coffeemachine.Drink;

public class Cashier {

    private Menu menu;

    public Cashier(Menu menu) {
        this.menu = menu;
    }

    public Money checkout(Drink drink, Money money) {
        Money drinkPrice = menu.getPrice(drink);
        if (money.getAmount() >= drinkPrice.getAmount()) {
            return Money.NONE;
        }
        return new Money(drinkPrice.getAmount() - money.getAmount());
    }


}
