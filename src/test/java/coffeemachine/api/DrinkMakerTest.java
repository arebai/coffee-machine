package coffeemachine.api;

import coffeemachine.model.Drink;
import coffeemachine.model.Money;
import coffeemachine.model.Order;
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
                        {anOrder(Drink.TEA, 1, false), "T:1:0"},
                        {anOrder(Drink.COFFEE, 2, false), "C:2:0"},
                        {anOrder(Drink.CHOCOLATE, 0, false), "H::"},
                        {anOrder(Drink.CHOCOLATE, 1, false), "H:1:0"},
                        {anOrder(Drink.TEA, 0, false), "T::"},
                        {anOrder(Drink.COFFEE, 0, false), "C::"},
                        {anOrder(Drink.JUICE, 0, false), "O::"},
                        {anOrder(Drink.COFFEE, 0, true), "Ch::"},
                        {anOrder(Drink.CHOCOLATE, 1, true), "Hh:1:0"},
                        {anOrder(Drink.TEA, 2, true), "Th:2:0"},

                }
        );
    }

    private static Order anOrder(Drink drink, int sugarAmount, boolean extraHot) {
        return Order.Builder
                .anOrder()
                .drink(drink)
                .sugarAmount(sugarAmount)
                .extraHot(extraHot)
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
