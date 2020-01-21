package coffeemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class DrinkMakerTest {

    private Order order;
    private String expectedInstruction;

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        {anOrder(Drink.TEA, 1), "T:1:0"},
                        {anOrder(Drink.COFFEE, 2), "C:2:0"},
                        {anOrder(Drink.CHOCOLATE, 0), "H::"},
                        {anOrder(Drink.CHOCOLATE, 1), "H:1:0"},
                        {anOrder(Drink.TEA, 0), "T::"},
                        {anOrder(Drink.COFFEE, 0), "C::"},
                }
        );
    }

    private static Order anOrder(Drink drink, int sugarAmount) {
        return Order.Builder
                .anOrder()
                .drink(drink)
                .sugarAmount(sugarAmount)
                .build();
    }

    public DrinkMakerTest(Order order, String expectedInstruction) {
        this.order = order;
        this.expectedInstruction = expectedInstruction;
    }

    @Test
    public void should_generate_instruction_when_process_order() {
        // given
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        Cashier cashier = mock(Cashier.class);
        when(cashier.computeMissingMoney(any(Order.class))).thenReturn(Money.NONE);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker, cashier);
        // when
        coffeeMachine.process(order);
        // then
        Mockito.verify(drinkMaker).send(expectedInstruction);
    }

}
