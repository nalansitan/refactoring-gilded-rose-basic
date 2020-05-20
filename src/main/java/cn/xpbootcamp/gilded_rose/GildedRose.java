package cn.xpbootcamp.gilded_rose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Goods[] goods;

    public GildedRose(Goods[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (int i = 0; i < goods.length; i++) {
            if (!goods[i].name.equals(AGED_BRIE)
                    && !goods[i].name.equals(BACKSTAGE_PASSES)) {
                if (goods[i].quality > 0) {
                    if (!goods[i].name.equals(SULFURAS)) {
                        goods[i].quality = goods[i].quality - 1;
                    }
                }
            } else {
                if (goods[i].quality < 50) {
                    goods[i].quality = goods[i].quality + 1;

                    if (goods[i].name.equals(BACKSTAGE_PASSES)) {
                        if (goods[i].sell_in < 11) {
                            if (goods[i].quality < 50) {
                                goods[i].quality = goods[i].quality + 1;
                            }
                        }

                        if (goods[i].sell_in < 6) {
                            if (goods[i].quality < 50) {
                                goods[i].quality = goods[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!goods[i].name.equals(SULFURAS)) {
                goods[i].sell_in = goods[i].sell_in - 1;
            }

            if (goods[i].sell_in < 0) {
                if (!goods[i].name.equals(AGED_BRIE)) {
                    if (!goods[i].name.equals(BACKSTAGE_PASSES)) {
                        if (goods[i].quality > 0) {
                            if (!goods[i].name.equals(SULFURAS)) {
                                goods[i].quality = goods[i].quality - 1;
                            }
                        }
                    } else {
                        goods[i].quality = 0;
                    }
                } else {
                    if (goods[i].quality < 50) {
                        goods[i].quality = goods[i].quality + 1;
                    }
                }
            }
        }
    }
}
