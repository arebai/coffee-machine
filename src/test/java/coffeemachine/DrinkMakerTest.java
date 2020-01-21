package coffeemachine;

import org.junit.Test;
import org.mockito.Mockito;

public class DrinkMakerTest {

    @Test
    public void should_generate_instruction_when_order_1_tea_with_1_sugar() {
        // given
        DrinkMaker drinkMaker = Mockito.mock(DrinkMaker.class);
        CoffeeMachine coffeeMachine = new CoffeeMachine(drinkMaker);
        Drink drink = Drink.TEA;
        Order order = new Order(drink, 1);
        // when
        coffeeMachine.process(order);
        // then
        Mockito.verify(drinkMaker).send("T:1:0");
    }
}
