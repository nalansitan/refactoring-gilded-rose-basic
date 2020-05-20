package cn.xpbootcamp.gilded_rose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    Goods[] goods;

    public GildedRose(Goods[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (int i = MIN_QUALITY; i < goods.length; i++) {
            if (!goods[i].name.equals(AGED_BRIE)
                    && !goods[i].name.equals(BACKSTAGE_PASSES)) {
                if (goods[i].quality > MIN_QUALITY) {
                    if (!goods[i].name.equals(SULFURAS)) {
                        goods[i].quality = goods[i].quality - 1;
                    }
                }
            } else if (goods[i].name.equals(BACKSTAGE_PASSES)) {
                goods[i].quality = calculate_backstage_pass(goods[i].sell_in, goods[i].quality);
            } else {
                if (goods[i].quality < MAX_QUALITY) {
                    goods[i].quality = goods[i].quality + 1;
                }
            }

            if (!goods[i].name.equals(SULFURAS)) {
                goods[i].sell_in = goods[i].sell_in - 1;
            }

            if (goods[i].sell_in < MIN_QUALITY) {
                if (!goods[i].name.equals(AGED_BRIE)) {
                    if (!goods[i].name.equals(BACKSTAGE_PASSES)) {
                        if (goods[i].quality > MIN_QUALITY) {
                            if (!goods[i].name.equals(SULFURAS)) {
                                goods[i].quality = goods[i].quality - 1;
                            }
                        }
                    } else {
                        goods[i].quality = MIN_QUALITY;
                    }
                } else {
                    if (goods[i].quality < MAX_QUALITY) {
                        goods[i].quality = goods[i].quality + 1;
                    }
                }
            }
        }
    }

    private int calculate_backstage_pass(int sell_in, int quality){
        quality += 1;
        if (sell_in < 11) {
            quality += 1;
        }
        if (sell_in < 6) {
            quality +=1;
        }
        if (quality > MAX_QUALITY){
            quality = MAX_QUALITY;
        }
        return quality;
    }
}
