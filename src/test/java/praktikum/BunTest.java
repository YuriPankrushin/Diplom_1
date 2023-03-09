package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    Bun bun = new Bun("oat bun", 500);

    @Test
    public void checkThatBunNameReturned() {
        Assert.assertEquals("oat bun", bun.getName());
    }

    @Test
    public void checkThatBunPriceReturned() {
        Assert.assertEquals(500, bun.getPrice(), 0);
    }
}