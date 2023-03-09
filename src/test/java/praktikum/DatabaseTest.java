package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {

    @Test
    public void checkThatDatabaseReturnsCorrectAmountOfAvailableBuns() {
        Database database = new Database();
        Assert.assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void checkThatDatabaseReturnsCorrectAmountOfAvailableIngredients() {
        Database database = new Database();
        Assert.assertEquals( 6, database.availableIngredients().size());
    }
}