package coffeemachine;

public class Order {

    private final Drink drink;
    private final int sugarAmount;

    public Order(Drink drink, int sugarAmount) {
        this.drink = drink;
        this.sugarAmount = sugarAmount;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugarAmount() {
        return sugarAmount;
    }

    public boolean withStick() {
        return true;
    }
}
