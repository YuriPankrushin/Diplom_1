package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void checkThatIngredientsAdded() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);

        Assert.assertEquals("Полученный чек не соответствует ожидаемому",
                String.format("(==== %s ====)%n" +
                                "= %s %s =%n" +
                                "(==== %s ====)%n" +
                                "%n" +
                                "Price: %f%n",
                bun.getName(), ingredient.getType().toString().toLowerCase(),
                        ingredient.getName(), bun.getName(), burger.getPrice()),
                burger.getReceipt());
    }

    @Test
    public void checkThatIngredientsRemoved() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals("Полученный чек не соответствует ожидаемому",
                String.format("(==== %s ====)%n" +
                                "(==== %s ====)%n" +
                                "%n" +
                                "Price: %f%n",
                        bun.getName(), bun.getName(), burger.getPrice()),
                burger.getReceipt());
    }

    @Test
    public void checkThatIngredientsMoved() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);

        Assert.assertEquals("Полученный чек не соответствует ожидаемому",
                String.format("(==== %s ====)%n" +
                                "= %s %s =%n" +
                                "= %s %s =%n" +
                                "(==== %s ====)%n" +
                                "%n" +
                                "Price: %f%n",
                        bun.getName(), ingredient.getType().toString().toLowerCase(),
                        ingredient.getName(), ingredient.getType().toString().toLowerCase(),
                        ingredient.getName(), bun.getName(), burger.getPrice()),
                burger.getReceipt());
    }
}
