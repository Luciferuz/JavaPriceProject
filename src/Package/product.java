package Package;

public class product {      //класс продукт
    private String name;    //название

    private void getName(String name) {
        this.name = name;
    }

    private void getPrice(int sum) {
        new price(sum);
    }

    public product(int price, String name) {
        getPrice(price);
        getName(name);
    }
}