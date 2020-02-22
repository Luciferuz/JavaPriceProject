package Package;

public class Product {      //класс продукт
    String name;    //название
    Price price;

    public Product(String name, Price price) {
        this.price = price;
        this.name = name;
    }

    public static class Price {
        int roubles;
        int kopecks;

        public Price(int roubles, int kopecks) {
            this.roubles = roubles;
            this.kopecks = kopecks;
        }
    }
}