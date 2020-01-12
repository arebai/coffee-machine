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
    private boolean extraHot;

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        {Drink.TEA, false, 1, true},
                        {Drink.TEA, false, 0, false},
                        {Drink.CHOCOLATE, false, 0, false},
                        {Drink.CHOCOLATE, true, 1, true},
                        {Drink.COFFEE, false, 2, true},
                        {Drink.COFFEE, false, 4, true},
                        {Drink.COFFEE, true, 0, false},
                        {Drink.JUICE, false, 0, false},

                }
        );
    }

    public OrderTest(Drink drink, boolean extraHot, int sugarAmount, boolean withStick) {
        this.drink = drink;
        this.sugarAmount = sugarAmount;
        this.withStick = withStick;
        this.extraHot = extraHot;
    }

    @Test
    public void should_create_order() {
        Order order = new Order(drink, extraHot, sugarAmount);
        assertThat(order.getDrink()).isEqualTo(drink);
        assertThat(order.getSugarAmount()).isEqualTo(sugarAmount);
        assertThat(order.withStick()).isEqualTo(withStick);
        assertThat(order.isExtraHot()).isEqualTo(extraHot);
    }
}
