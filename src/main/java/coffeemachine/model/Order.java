package coffeemachine.model;

public class Order {
    private Drink drink;
    private int sugarAmount;
    private Money money;

    private Order() {

    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugarAmount() {
        return sugarAmount;
    }

    public boolean withSugar() {
        return sugarAmount >= 1;
    }

    public Money getMoney() {
        return money;
    }

    public static final class Builder {
        private Drink drink;
        private int sugarAmount;
        private Money money;

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

        public Builder money(Money money) {
            this.money = money;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.sugarAmount = this.sugarAmount;
            order.money = this.money;
            order.drink = this.drink;
            return order;
        }
    }
}
