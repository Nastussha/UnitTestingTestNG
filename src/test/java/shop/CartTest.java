package shop;

import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class CartTest {
    private Cart cart1, cart2, cart3;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeTest
    public void setUp() {
        cart1 = new Cart("TestCart1");
        cart2 = new Cart("TestCart2");
        cart3 = new Cart("TestCart3");
        realItem = new RealItem();
        virtualItem = new VirtualItem();
        realItem.setPrice(2500);
        virtualItem.setPrice(2000);
        cart1.addRealItem(realItem);
        cart2.addVirtualItem(virtualItem);
        cart3.addRealItem(realItem);
        cart3.addVirtualItem(virtualItem);
    }

    @Ignore
    @Test (groups = { "getTotalPrice.RealItem" })
    void getTotalPriceRealItem() {
        Assert.assertEquals(cart1.getTotalPrice(), 3000);
    }

    @Test (groups = { "getTotalPrice.VirtualItem" })
    void getTotalPriceVirtualItem() {
        Assert.assertEquals(cart2.getTotalPrice(), 2400);
    }

    @Test (groups = { "getTotalPrice.AllItems" })
    void getTotalPriceAllItems() {
        Assert.assertEquals(cart3.getTotalPrice(), 5400);
    }

    @AfterTest
    public void tearDown() {
        cart1 = null;
        cart2 = null;
    }
}
