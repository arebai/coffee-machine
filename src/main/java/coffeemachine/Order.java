package coffeemachine;

public class Order {

    private final Drink drink;
    private final int sugarAmount;
    private final boolean extraHot;

    public Order(Drink drink, boolean extraHot, int sugarAmount) {
        this.drink = drink;
        this.extraHot = extraHot;
        this.sugarAmount = sugarAmount;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugarAmount() {
        return sugarAmount;
    }

    public boolean withStick() {
        return sugarAmount >= 1;
    }

    public boolean isExtraHot() {
        return extraHot;
    }
}
