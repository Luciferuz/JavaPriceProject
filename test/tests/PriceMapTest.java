package tests;
import org.junit.Test;
import Package.Product;
import Package.PriceMap;
import java.util.HashMap;
import java.util.Map;
import Package.Product.Price;
import static org.junit.Assert.*;


public class PriceMapTest {

    @Test
    public void addProduct() {
        PriceMap priceMap1 = new PriceMap(Map.of(12, new Product("Мясо", new Price(3,4))));
        Product add1 = new Product("Молоко", new Product.Price(67,99));

        priceMap1.addProduct(add1, 34);
        assertEquals(add1, priceMap1.getProduct(34));
    }

    @Test
    public void deleteProduct() {
        PriceMap priceMap1 = new PriceMap(Map.of(12, new Product("Мясо", new Price(3,4))));
        PriceMap priceMap2 = new PriceMap(Map.of(12, new Product("Мясо", new Price(3,4)),
                                                 34, new Product("Молоко", new Price(67,99))));

        priceMap2.deleteProduct(34);
        assertEquals(priceMap2, priceMap1);
    }

    @Test //passed
    public void changeName() {
        PriceMap priceMap = new PriceMap(Map.of(23, new Product("Мясо", new Price(3,4)),
                34, new Product("Молоко", new Price(45,23)),
                21, new Product("Минеральная вода", new Price(23,44)),
                90, new Product("Мороженое", new Price(99,90)),
                42, new Product("Сметана", new Price(55,30))));
        priceMap.changeName(42, "Сметана1");
        priceMap.changeName(90, "Замороженный");
        priceMap.changeName(23, "Мое мясо");
        assertEquals("Сметана1", priceMap.getName(42));
        assertEquals("Замороженный", priceMap.getName(90));
        assertEquals("Мое мясо", priceMap.getName(23));
    }

    @Test //passed
    public void changePrice() {
        PriceMap priceMap = new PriceMap(Map.of(23, new Product("Мясо", new Price(3,4)),
                34, new Product("Молоко", new Price(45,23)),
                21, new Product("Минеральная вода", new Price(23,44)),
                90, new Product("Мороженое", new Price(99,90)),
                42, new Product("Сметана", new Price(55,30))));

        priceMap.changePrice(90, new Price(24,56));
        Integer sum1 = priceMap.getPrice(priceMap.purchase(90, 1));
        Integer answer1 = 2456;

        priceMap.changePrice(42, new Price(123,59));
        Integer sum2 = priceMap.getPrice(priceMap.purchase(42, 1));
        Integer answer2 = 12359;

        assertEquals(sum1, answer1);
        assertEquals(sum2, answer2);
    }

    @Test //passed
    public void purchase() {
        PriceMap priceMap = new PriceMap(Map.of(23, new Product("Мясо", new Price(3,4)),
                34, new Product("Молоко", new Price(45,23)),
                21, new Product("Минеральная вода", new Price(23,44)),
                90, new Product("Мороженое", new Price(99,90)),
                42, new Product("Сметана", new Price(55,30))));

        //выдает в копейках
        Integer sum1 = priceMap.getPrice(priceMap.purchase(21, 1));
        Integer mySum1 = 2344;

        Integer sum2 = priceMap.getPrice(priceMap.purchase(90, 8));
        Integer mySum2 = 79920;

        Integer sum3 = priceMap.getPrice(priceMap.purchase(34, 9));
        Integer mySum3 = 40707;

        assertEquals(sum1, mySum1);
        assertEquals(sum2, mySum2);
        assertEquals(sum3, mySum3);
    }
}