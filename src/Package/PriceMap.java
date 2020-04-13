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
        Product prod = products.get(code);
        if (prod == null) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        else prod.setName(name);
    }

    public void changePrice(Integer code, Price price) { //изменение цены по коду
        Product prod = products.get(code);
        if (prod == null) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        else prod.setPrice(price);
    }

    public Price purchase(Integer code, int number) {
        Product prod = products.get(code);
        if (prod == null) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        else return new Price(prod.getPrice().getPriceKopecks() * number);
    }

    public String getName(Integer code) {
        Product prod = products.get(code);
        if (prod == null) throw new IllegalArgumentException("Продукт с таким кодом отсутствует");
        else return prod.getName();
    }

    public Product getProduct(Integer code) {
        return products.get(code);
    }

}