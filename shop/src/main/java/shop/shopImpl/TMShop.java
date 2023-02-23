package shop.shopImpl;

import shop.Shop;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 13:03
 * 文件描述：
 */
public class TMShop implements Shop {
    @Override
    public void sell() {
        System.out.println("生活用品");
    }
    public void ad(){
        System.out.println("买东西，上天猫");
    }
}
