package practikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType expectedIngredientType = IngredientType.SAUCE;
    private String expectedName = "TestSauce";
    private float expectedPrice = 20f;

    @Before
    public void setUp() {
        this.ingredient = new Ingredient(
                expectedIngredientType,
                expectedName,
                expectedPrice
        );
    }

    @Test
    public void priceIsCorrect() {
        MatcherAssert.assertThat(
                "Некорректная стоимость ингредиента",
                ingredient.getPrice(),
                equalTo(expectedPrice)
        );
    }

    @Test
    public void nameIsCorrect() {
        MatcherAssert.assertThat(
                "Некорректное наименование ингредиента",
                ingredient.getName(),
                equalTo(expectedName)
        );
    }

    @Test
    public void typeIsCorrect() {
        MatcherAssert.assertThat(
                "Некорректный тип ингредиента",
                ingredient.getType(),
                equalTo(expectedIngredientType)
        );
    }
}
