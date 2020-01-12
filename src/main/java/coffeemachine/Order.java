package coffeemachine;

public class Order {

    private final Drink drink;
    private final int sugarAmount;
    private final Hot hot;

    public Order(Drink drink, boolean isExtraHot, int sugarAmount) {
        this.drink = drink;
        this.hot = isExtraHot ? Hot.EXTRA : Hot.DEFAULT;
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
        return hot == Hot.EXTRA;
    }
}
