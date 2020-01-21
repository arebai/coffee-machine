package coffeemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DrinkMakerTest {

    private Order order;
    private String expectedInstruction;

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[][]{
                        { new Order(Drink.TEA, 1), "T:1:0"},
                        { new Order(Drink.COFFEE, 2), "C:2:0"},
                        { new Order(Drink.CHOCOLATE, 0), "H::"},

                }
        );
    }

    public DrinkMakerTest(Order order, String expectedInstruction) {
        this.order = order;
        this.expectedInstruction = expectedInstruction;
    }

    @Test
    public void should_generate_instruction_when_process_order() {
        // given
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);
        // when
        coffeeMachine.process(order);
        // then
        Mockito.verify(drinkMaker).send(expectedInstruction);
    }

}
