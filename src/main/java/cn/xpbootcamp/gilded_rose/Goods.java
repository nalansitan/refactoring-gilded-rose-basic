package cn.xpbootcamp.gilded_rose;

public class Goods {

    public String name;

    public int sell_in;

    public int quality;

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public static final int MIN_SELLIN = 0;

    public Goods(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
