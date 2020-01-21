package coffeemachine;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void process(Order order) {

        String instruction = generateOrderInstruction(order);
        drinkMaker.send(instruction);
    }

    private String generateOrderInstruction(Order order) {
        Drink drink = order.getDrink();
        String sugarAndStickInstruction = order.withSugar() ? order.getSugarAmount() + ":0" : ":";
        return drink.getKey() + ":" + sugarAndStickInstruction;
    }
}
