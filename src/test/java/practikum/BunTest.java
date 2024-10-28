package practikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class BunTest {

    @Test
    public void getBunNameIsCorrect() {
        String testBunName = "Chees Bun";
        Bun bun = new Bun(testBunName, 95.5f);
        MatcherAssert.assertThat(
                "Название булочки некорректно",
                bun.getName(),
                equalTo(testBunName)
        );
    }

    @Test
    public void getBunPriceIsCorrect() {
        float testBunPrice = 95.5f;
        Bun bun = new Bun("Chees Bun", testBunPrice);
        MatcherAssert.assertThat(
                "Стоимость булочки некорректна",
                bun.getPrice(),
                equalTo(testBunPrice)
        );
    }
}
