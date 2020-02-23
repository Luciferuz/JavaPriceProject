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
        PriceMap priceMap2 = new PriceMap(Map.of(12, new Product("Мясо", new Price(3,4)),
                                                 34, new Product("Молоко", new Price(67,99))));

        Product add1 = new Product("Молоко", new Product.Price(67,99));

        priceMap1.addProduct(add1, 34);
        assertEquals(priceMap1, priceMap2);
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
        PriceMap priceMap1 = new PriceMap(Map.of(12, new Product("Мясо", new Price(3,4))));
        priceMap1.changeName(12, "Сосиска");
        assertEquals("Сосиска", priceMap1.getName(12));
    }

    @Test
    public void changePrice() {
        PriceMap priceMap1 = new PriceMap(Map.of(12, new Product("Мясо", new Price(3,4))));
        priceMap1.changePrice(12, new Price(24,56));
        assertEquals(new Price(24,56), priceMap1.getPrice(12));
    }

    @Test
    public void purchase() {

    }
}