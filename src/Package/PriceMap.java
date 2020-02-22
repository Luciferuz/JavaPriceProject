package Package;
import java.util.Map;
import Package.Product.Price;

public class PriceMap {

    public Map<Integer, Product> products;

    public PriceMap(Map<Integer, Product> products) {
        this.products = products;
    }

    public void addProduct(Product product, Integer code) { //добавили продукт и его код
       products.put(code, product);
    }

    public void deleteProduct(Integer code) { //удалили продукт, зная его код
        products.remove(code);
    }

    public void changeName(Integer code, String name) { //изменение имени по коду
        products.get(code).name = name;
    }

    public void changePrice(Integer code, Price price) { //изменение цены по коду
        products.get(code).price = price;
    }

    public Price purchase(Integer code, Integer number) {
        Integer newKopecks = products.get(code).price.kopecks * number;
        Integer newRoubles = products.get(code).price.roubles * number;
        if (newKopecks > 100) {
            newRoubles += newKopecks % 100;
            newKopecks /= 100;
        }
        return new Price(newRoubles, newKopecks);
    }
}