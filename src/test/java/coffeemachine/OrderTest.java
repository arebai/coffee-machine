package coffeemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class OrderTest {

    private Drink drink;
    private int sugarAmount;
    private boolean withStick;

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        {Drink.TEA, 1, true},
                        {Drink.CHOCOLATE, 0, false},
                }
        );
    }

    public OrderTest(Drink drink, int sugarAmount, boolean withStick) {
        this.drink = drink;
        this.sugarAmount = sugarAmount;
        this.withStick = withStick;
    }

    @Test
    public void should_create_order() {
        Order order = new Order(drink, sugarAmount);
        assertThat(order.getDrink()).isEqualTo(drink);
        assertThat(order.getSugarAmount()).isEqualTo(sugarAmount);
        assertThat(order.withStick()).isEqualTo(withStick);
    }
}
