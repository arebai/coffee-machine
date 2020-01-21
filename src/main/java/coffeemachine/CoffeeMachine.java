package coffeemachine;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void process(Order order) {

        String instruction = order.getDrink().getKey() + ":" + order.getSugarAmount() + ":0";
        drinkMaker.send(instruction);
    }
}
