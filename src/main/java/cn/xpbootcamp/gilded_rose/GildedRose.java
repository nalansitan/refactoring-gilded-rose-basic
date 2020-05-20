package cn.xpbootcamp.gilded_rose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public static final int MIN_SELLIN = 0;
    Goods[] goods;

    public GildedRose(Goods[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (int i = 0; i < goods.length; i++) {
            if (goods[i].name.equals(BACKSTAGE_PASSES)) {
                calculate_backstage_pass(goods[i]);
            } else if (goods[i].name.equals(AGED_BRIE)){
                calculate_aged_brie(goods[i]);
            } else if (goods[i].name.equals(SULFURAS)) {
                calculate_sulfuras(goods[i]);
            } else {
                calculate_normal_goods(goods[i]);
            }
            if (goods[i].quality > MAX_QUALITY) {
                goods[i].quality = MAX_QUALITY;
            }
            if (goods[i].quality < MIN_QUALITY) {
                goods[i].quality = MIN_QUALITY;
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
        good.sell_in -=1;
        if (good.sell_in < MIN_SELLIN){
            good.quality = MIN_QUALITY;
        }
    }

    private void calculate_aged_brie(Goods good){
        good.quality += 1;
        good.sell_in -= 1;
        if (good.sell_in < MIN_SELLIN) {
            good.quality += 1;
        }
    }

    private void calculate_sulfuras(Goods good){
        return;
    }

    private void calculate_normal_goods(Goods good){
        good.quality -= 1;
        good.sell_in -= 1;
        if (good.sell_in < MIN_SELLIN) {
            good.quality -= 1;
        }
    }
}
