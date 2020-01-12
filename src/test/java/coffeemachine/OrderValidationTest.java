package coffeemachine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderValidationTest {

    @Test
    public void should_return_none_when_invalid_order() {
        Order extraHotJuice = Order.Builder
                .anOrder()
                .drink(Drink.JUICE)
                .hot(Hot.EXTRA)
                .build();

        assertThat(extraHotJuice).isEqualTo(Order.NONE);
    }
}
