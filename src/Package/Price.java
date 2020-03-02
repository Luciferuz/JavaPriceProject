package Package;

public class Price {
    int roubles;
    int kopecks;

    public Price(int roubles, int kopecks) {
        this.roubles = roubles;
        this.kopecks = kopecks;
    }

    public Price(int kopecks) {
        this.roubles = kopecks / 100;
        this.kopecks = kopecks % 100;
    }

    public int getPriceKopecks() {
        return roubles * 100 + kopecks;
    }

    public void getPrice() {
        new Price(roubles, kopecks);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(roubles).hashCode() + Integer.valueOf(kopecks).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Price price = (Price) object;

        return Integer.valueOf(roubles).equals(price.roubles) && Integer.valueOf(kopecks).equals(price.kopecks);
    }

}
