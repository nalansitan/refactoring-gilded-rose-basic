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
                calculate_backstage_pass(goods[i]);
            } else if (goods[i].name.equals(AGED_BRIE)){
                calculate_aged_brie(goods[i]);
            }

            if (!goods[i].name.equals(SULFURAS)
                    && !goods[i].name.equals(BACKSTAGE_PASSES)
                    && !goods[i].name.equals(AGED_BRIE)) {
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

    private void calculate_backstage_pass(Goods good){
        good.quality += 1;
        if (good.sell_in < 11) {
            good.quality += 1;
        }
        if (good.sell_in < 6) {
            good.quality +=1;
        }
        if (good.quality > MAX_QUALITY){
            good.quality = MAX_QUALITY;
        }
        good.sell_in -=1;
    }

    private void calculate_aged_brie(Goods good){
        good.quality += 1;
        if (good.quality > MAX_QUALITY){
            good.quality = MAX_QUALITY;
        }
        good.sell_in -= 1;
    }
}
