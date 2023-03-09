package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Database dateBase;


    @Test
    public void checkSetBunsGetNameMethod() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        burger.setBuns(bun);
        Assert.assertEquals("black bun", bun.getName());
    }

    @Test
    public void checkSetBunsGetPriceMethod() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Assert.assertEquals(100f, bun.getPrice(), 0);
    }

    @Test
    public void checkAddIngredientMethod() {
        Burger burger = new Burger();
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredient);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
        Assert.assertEquals("cutlet", ingredient.getName());
        Assert.assertEquals(100f, ingredient.getPrice(), 0);
    }

    @Test
    public void checkRemoveIngredientMethod() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredientMethod() {
        Burger burger = new Burger();
        Mockito.when(dateBase.availableIngredients()).thenReturn(List.of(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200)));
        burger.addIngredient(dateBase.availableIngredients().get(0));
        burger.addIngredient(dateBase.availableIngredients().get(1));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("hot sauce", burger.ingredients.get(1).getName());
    }

    @Test
    public void checkGetPriceMethod() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Mockito.when(dateBase.availableIngredients()).thenReturn(List.of(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200)));
        burger.addIngredient(dateBase.availableIngredients().get(0));
        burger.addIngredient(dateBase.availableIngredients().get(1));
        Assert.assertEquals(500f, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptMethod() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Mockito.when(dateBase.availableIngredients()).thenReturn(List.of(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200)));
        burger.addIngredient(dateBase.availableIngredients().get(0));
        burger.addIngredient(dateBase.availableIngredients().get(1));
        Assert.assertEquals("(==== black bun ====)\n" +
                                "= sauce hot sauce =\n" +
                                "= sauce sour cream =\n" +
                                "(==== black bun ====)\n" +
                                "\n" +
                                "Price: 500.000000\n",
                                burger.getReceipt());
    }
}