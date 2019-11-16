package parser;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

import java.io.File;

public class JsonParserTest {
    private Parser parser;
    Cart nastyaCart = new Cart("nastya-cart");
    RealItem car = new RealItem();
    File file;

    @BeforeMethod
    public void setUp() {
        parser = new JsonParser();

    }

    @Test(groups = { "writeToFile" })
    void writeToFile() {
        file = new File("src/main/resources/nastya-cart.json");
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);
        nastyaCart.addRealItem(car);
        parser.writeToFile(nastyaCart);
        Assert.assertEquals(file.exists(), true);
    }

    @Test(groups = { "readFromFile_NotNull" })
    void readFromFile_NotNull() {
        Assert.assertNotNull(parser.readFromFile(new File("src/main/resources/eugen-cart.json")));
    }

    @Parameters({ "pathName"})
    @Test(groups = { "readFromFile_NoSuchFileException" })
    void readFromFile_NoSuchFileException(String pathName) {
        Assert.assertThrows(Exception.class, () -> parser.readFromFile(new File(pathName)));
        //Assert.assertEquals("File "+ pathName + ".json not found!", exception.getMessage());
    }

    @AfterMethod
    public void tearDown() {
        parser = null;
        if (file != null){
            file.delete();
        }
    }
}
