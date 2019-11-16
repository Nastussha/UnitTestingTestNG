package parser;

import org.testng.Assert;
import org.testng.annotations.*;
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

    @Test(groups = {"writeToFile"})
    void writeToFile() {
        file = new File("src/main/resources/nastya-cart.json");
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);
        nastyaCart.addRealItem(car);
        parser.writeToFile(nastyaCart);
        Assert.assertTrue(file.exists(), "File does not exist");
    }

    @Test(groups = {"readFromFile_NotNull"})
    void readFromFile_NotNull() {
        Assert.assertNotNull(parser.readFromFile(new File("src/main/resources/eugen-cart.json")));
    }

    @Parameters({"pathName"})
    @Test(groups = {"readFromFile_NoSuchFileException"})
    void readFromFile_NoSuchFileException(String pathName) {
        Assert.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File(pathName)));
    }

    @Test(dataProvider = "pathNameSource")
    void readFromFile_NoSuchFileException2(String pathName) {
        Assert.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File(pathName)));
    }

    @DataProvider
    public Object[][] pathNameSource() {
        return new String[][]{
                {"src/main/resources/nastya-cart.json"},
                {"src/main/resources/andrew-cart1.json"}

        };
    }

    @AfterMethod
    public void tearDown() {
        parser = null;
        if (file != null) {
            file.delete();
        }
    }
}
