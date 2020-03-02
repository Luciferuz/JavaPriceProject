package Package;
import java.util.Objects;

public class Price {
    private int roubles;
    private int kopecks;

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

    @Override
    public int hashCode() {
        return Objects.hash(roubles, kopecks);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Price price = (Price) object;
        return roubles == price.roubles && kopecks == price.kopecks;
    }

}
