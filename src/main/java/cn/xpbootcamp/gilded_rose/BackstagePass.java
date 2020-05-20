package cn.xpbootcamp.gilded_rose;

public class BackstagePass extends Goods implements UpdateSellInQuality{
    public BackstagePass(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void update_quality() {
        this.quality += 1;
        if (this.sell_in < 11) {
            this.quality += 1;
        }
        if (this.sell_in < 6) {
            this.quality +=1;
        }
        this.sell_in -=1;
        if (this.sell_in < MIN_SELLIN){
            this.quality = MIN_QUALITY;
        }
        if (this.quality > MAX_QUALITY) {
            this.quality = MAX_QUALITY;
        }
        if (this.quality < MIN_QUALITY) {
            this.quality = MIN_QUALITY;
        }
    }
}
