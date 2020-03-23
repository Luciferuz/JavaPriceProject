package Package;
import java.util.HashMap;
import java.util.Map;

public class PriceMap {

    private Map<Integer, Product> products;

    public PriceMap(Map<Integer, Product> products) {
        this.products = new HashMap<Integer, Product>(products);
    }

    public PriceMap() {
        products = new HashMap<Integer, Product>();
    }

    public void addProduct(Product product, Integer code) { //добавили продукт и его код
        if (products.putIfAbsent(code, product) != null) throw new IllegalArgumentException("Продукт с таким кодом уже существует");
    }

    public boolean deleteProduct(Integer code) { //удалили продукт, зная его код
        return products.remove(code) != null;
    }

    public void changeName(Integer code, String name) { //изменение имени по коду
        if (!products.containsKey(code)) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        products.get(code).setName(name);
    }

    public void changePrice(Integer code, Price price) { //изменение цены по коду
        if (!products.containsKey(code)) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        products.get(code).setPrice(price);
    }

    public Price purchase(Integer code, int number) {
        if (!products.containsKey(code)) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        return new Price(products.get(code).getPrice().getPriceKopecks() * number);
    }

    public String getName(Integer code) {
        if (!products.containsKey(code)) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        return products.get(code).getName();
    }

    public Product getProduct(Integer code) {
        return products.get(code);
    }

}