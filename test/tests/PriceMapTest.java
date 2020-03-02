package tests;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import Package.Price;
import Package.Product;
import Package.PriceMap;
import static org.junit.Assert.*;


public class PriceMapTest {

    @Test //passed
    public void addProduct() {
        Map<Integer, Product> products = new HashMap<>();
        products.put(12, new Product("Молоко", new Price(63,99)));
        products.put(21, new Product("Мясо", new Price(3,4)));

        PriceMap priceMap = new PriceMap(products);
        priceMap.addProduct(new Product("Минеральная вода", new Price(23,44)), 43);
        priceMap.addProduct(new Product("Сметана", new Price(55,30)), 52);

        assertEquals(new Product("Молоко", new Price(63,99)), priceMap.getProduct(12));
        assertEquals(new Product("Мясо", new Price(3,4)), priceMap.getProduct(21));
        assertEquals(new Product("Минеральная вода", new Price(23,44)), priceMap.getProduct(43));
        assertEquals(new Product("Сметана", new Price(55,30)), priceMap.getProduct(52));
    }

    @Test //passed
    public void deleteProduct() {
        Map<Integer, Product> products = new HashMap<>();

        products.put(12, new Product("Молоко", new Price(63,99)));
        products.put(21, new Product("Мясо", new Price(3,4)));
        products.put(43, new Product("Минеральная вода", new Price(23,44)));
        products.put(52, new Product("Сметана", new Price(55,30)));

        PriceMap priceMap = new PriceMap(products);

        priceMap.deleteProduct(43);
        priceMap.deleteProduct(21);
        assertEquals(new Product("Молоко", new Price(63,99)), priceMap.getProduct(12));
        assertNull(priceMap.getProduct(21));
        assertNull(priceMap.getProduct(43));
        assertEquals(new Product("Сметана", new Price(55,30)), priceMap.getProduct(52));
    }

    @Test //passed
    public void changeName() {
        PriceMap priceMap = new PriceMap(Map.of(
                23, new Product("Мясо", new Price(3,4)),
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
        assertEquals("Молоко", priceMap.getName(34));
        assertEquals("Минеральная вода", priceMap.getName(21));
    }

    @Test //passed
    public void changePrice() {
        PriceMap priceMap = new PriceMap(Map.of(
                23, new Product("Мясо", new Price(3,4)),
                34, new Product("Молоко", new Price(45,23)),
                21, new Product("Минеральная вода", new Price(23,44)),
                90, new Product("Мороженое", new Price(99,90)),
                42, new Product("Сметана", new Price(55,30))));

        priceMap.changePrice(90, new Price(24,56));
        priceMap.changePrice(42, new Price(123,59));

        assertEquals(2456, priceMap.getProduct(90).getPrice().getPriceKopecks());
        assertEquals(12359, priceMap.getProduct(42).getPrice().getPriceKopecks());
    }

    @Test //passed
    public void purchase() {
        PriceMap priceMap = new PriceMap(Map.of(
                23, new Product("Мясо", new Price(3,4)),
                34, new Product("Молоко", new Price(45,23)),
                21, new Product("Минеральная вода", new Price(23,44)),
                90, new Product("Мороженое", new Price(99,90)),
                42, new Product("Сметана", new Price(55,30))));

        assertEquals(2344, priceMap.purchase(21,1).getPriceKopecks());
        assertEquals(79920, priceMap.purchase(90,8).getPriceKopecks());
        assertEquals(40707, priceMap.purchase(34,9).getPriceKopecks());
    }
}