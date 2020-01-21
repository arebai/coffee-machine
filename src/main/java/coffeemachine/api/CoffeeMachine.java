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
            sendInstruction(generateMissingMoneyInstruction(missingMoney));
            return;
        }
        sendInstruction(generateOrderInstruction(order));
    }

    private String generateMissingMoneyInstruction(Money missingMoney) {
        String missingMoneyText = String.format("%.2f", missingMoney.getAmount());
        return "MISSING_MONEY:" + missingMoneyText;
    }


    private String generateOrderInstruction(Order order) {
        Drink drink = order.getDrink();
        String sugarAndStickInstruction = order.withSugar() ? order.getSugarAmount() + ":0" : ":";
        return drink.getKey() + ":" + sugarAndStickInstruction;
    }

    private void sendInstruction(String instruction) {
        drinkMaker.send(instruction);
    }
}
