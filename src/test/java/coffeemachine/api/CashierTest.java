package coffeemachine.api;

import coffeemachine.api.impl.CashierImpl;
import coffeemachine.model.Drink;
import coffeemachine.model.Money;
import coffeemachine.model.Order;
import org.assertj.core.data.Offset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CashierTest {

    private static Offset<Double> OFFSET = Offset.offset(0.0000001);

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        {anOrder(Drink.TEA, new Money(0.1)), new Money(0.3)},
                        {anOrder(Drink.TEA, new Money(0.3)), new Money(0.1)},
                        {anOrder(Drink.TEA, new Money(0.5)), Money.NONE}
                }
        );
    }

    private Order order;
    private Money expectedMissingMoney;

    public CashierTest(Order order, Money expectedMissingMoney) {
        this.order = order;
        this.expectedMissingMoney = expectedMissingMoney;
    }


    @Test
    public void should_compute_missing_money() {
        Cashier cashier = new CashierImpl();
        Money missingMoney = cashier.computeMissingMoney(this.order);
        assertThat(missingMoney.getAmount())
                .isCloseTo(this.expectedMissingMoney.getAmount(), OFFSET);
    }

    private static Order anOrder(Drink drink, Money money) {
        return Order.Builder
                .anOrder()
                .drink(drink)
                .money(money)
                .build();
    }
}
