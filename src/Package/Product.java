package Package;
import java.util.Objects;

public class Product {
    private String name;
    private Price price;

    public Product(String name, Price price) {
        this.price = price;
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return price.equals(product.price) && name.equals(product.name);
    }
}