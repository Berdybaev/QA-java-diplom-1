package practikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient_2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void shouldSetBun() {
        Mockito.when(bun.getName()).thenReturn("TestBun");
        burger.setBuns(bun);
        MatcherAssert.assertThat("Не установлено название булочки", bun.getName(), equalTo(burger.bun.getName()));
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue("Ингредиент не добалвен", burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);

        int initialIndex = burger.ingredients.indexOf(ingredient);
        int targetIndex = burger.ingredients.indexOf(ingredient_2);

        burger.moveIngredient(initialIndex, targetIndex);

        MatcherAssert.assertThat("Ингредиент не перемещен", burger.ingredients.get(targetIndex), equalTo(ingredient));
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        assertFalse("Ингредиент не убран", burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldCalculatePrice() {
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(20f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals("Неверная цена", 40f, burger.getPrice(), 0.01f);
    }

    @Test
    public void shouldGenerateReceipt() {
        Mockito.when(bun.getName()).thenReturn("TestBun");
        Mockito.when(bun.getPrice()).thenReturn(20f);
        Mockito.when(ingredient.getName()).thenReturn("TestIngredient");
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt = "(==== TestBun ====)\r\n" +
                "= filling TestIngredient =\r\n" +
                "(==== TestBun ====)\r\n" +
                "\r\nPrice: 50,000000\r\n";

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat("Неверный чек", burger.getReceipt(), equalTo(expectedReceipt));
    }
}
