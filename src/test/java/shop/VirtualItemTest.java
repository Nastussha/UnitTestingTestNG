package shop;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VirtualItemTest {
    private VirtualItem virtualItem;

    @BeforeTest
    public void setUp() {
        virtualItem = new VirtualItem();
    }

    @Test (groups = { "VirtualItem.toStringTest" })
    void toStringTest() {
        Assert.assertEquals("Class: class shop.VirtualItem; Name: null; Price: 0.0; Size on disk: 0.0",
                virtualItem.toString());
    }

    @AfterTest
    public void tearDown() {
        virtualItem = null;
    }
}
