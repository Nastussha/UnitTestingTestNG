package shop;

import org.testng.Assert;
import org.testng.annotations.*;

@Test (groups = { "RealItemTest" })
public class RealItemTest {
    private RealItem realItem;

    @BeforeClass
    public void setUp() {
        realItem = new RealItem();
    }

    @Test (groups = { "RealItem.toStringTest" })
    void toStringTest() {
        Assert.assertEquals("Class: class shop.RealItem; Name: null; Price: 0.0; Weight: 0.0",
                realItem.toString());
    }

    @AfterClass
    public void tearDown() {
        realItem = null;
    }

}
