package Package;

public class Product {
    String name;
    public Price price;

    public Product(String name, Price price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return price.hashCode() + name.hashCode();
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