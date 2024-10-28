package practikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String typeName;

    @Parameterized.Parameters(name = "Проверка типа: {1}")
    public static Object[][] paramsForTest() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    public IngredientTypeTest(IngredientType ingredientType, String typeName) {
        this.ingredientType = ingredientType;
        this.typeName = typeName;
    }

    @Test
    public void ingredientTypeExists() {
        MatcherAssert.assertThat(
                "Некорректный тип ингредиента: " + typeName,
                ingredientType,
                is(IngredientType.valueOf(typeName))
        );
    }
}
