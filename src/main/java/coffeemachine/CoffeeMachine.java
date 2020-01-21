package coffeemachine;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void process(Order order) {
        drinkMaker.send("T:1:0");
    }
}
