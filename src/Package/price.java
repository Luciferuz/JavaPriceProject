package Package;

class price {        // класс цена товара

    private int kopecks;

    price(int kopecks) {
        getKopecks(kopecks);
    }

    private void getKopecks(int kopecks) {
        if (kopecks >= 100) {
            kopecks /= 100;
        }
        this.kopecks = kopecks;
    }
}