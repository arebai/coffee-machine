package coffeemachine.api;

import coffeemachine.model.Drink;
import coffeemachine.model.Money;
import coffeemachine.model.Order;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private final Cashier cashier;

    public CoffeeMachine(DrinkMaker drinkMaker, Cashier cashier) {
        this.drinkMaker = drinkMaker;
        this.cashier = cashier;
    }

    public void process(Order order) {
        Money missingMoney = cashier.computeMissingMoney(order);
        if (missingMoney != Money.NONE) {
            drinkMaker.send("MISSING_MONEY:0.3");
            return;
        }
        String instruction = generateOrderInstruction(order);
        drinkMaker.send(instruction);
    }

    private String generateOrderInstruction(Order order) {
        Drink drink = order.getDrink();
        String sugarAndStickInstruction = order.withSugar() ? order.getSugarAmount() + ":0" : ":";
        return drink.getKey() + ":" + sugarAndStickInstruction;
    }
}
