package coffeemachine;

public class Order {

    private Drink drink;
    private int sugarAmount;
    private Hot hot;

    private Order() {
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


    public static final class Builder {
        private Drink drink;
        private int sugarAmount;
        private Hot hot;

        private Builder() {
        }

        public static Builder anOrder() {
            return new Builder();
        }

        public Builder drink(Drink drink) {
            this.drink = drink;
            return this;
        }

        public Builder sugarAmount(int sugarAmount) {
            this.sugarAmount = sugarAmount;
            return this;
        }

        public Builder hot(Hot hot) {
            this.hot = hot;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.drink = this.drink;
            order.hot = this.hot;
            order.sugarAmount = this.sugarAmount;
            return order;
        }
    }
}
