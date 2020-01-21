package coffeemachine;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CashierTest {

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        {anOrder(Drink.TEA, new Money(0.1)), new Money(0.3)}
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
    public void should_compute_missing_money(){
        Cashier cashier = new CashierImpl();
        Assertions.assertThat(cashier.computeMissingMoney(this.order)).isEqualTo(this.expectedMissingMoney);
    }

    private static Order anOrder(Drink drink, Money money) {
        return Order.Builder
                .anOrder()
                .drink(drink)
                .money(money)
                .build();
    }
}
