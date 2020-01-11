package coffeemachine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    @Test
    public void should_create_order_of_1_tea_with_1_sugar_and_a_stick() {
        Drink drink = Drink.TEA;
        int sugarAmount = 1;
        Order order = new Order(drink, sugarAmount);
        assertThat(order.getDrink()).isEqualTo(drink);
        assertThat(order.getSugarAmount()).isEqualTo(sugarAmount);
        assertThat(order.withStick()).isTrue();
    }

    @Test
    public void should_create_order_of_1_of_chocolate_with_no_sugar_and_no_stick() {
        Drink chocolate = Drink.CHOCOLATE;
        int noSugar = 0;
        Order order = new Order(chocolate, noSugar);
        assertThat(order.getDrink()).isEqualTo(chocolate);
        assertThat(order.getSugarAmount()).isEqualTo(noSugar);
        assertThat(order.withStick()).isFalse();
    }
}
