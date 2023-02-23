package shop.shopImpl;

import shop.Shop;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 13:03
 * 文件描述：
 */
public class JDShop implements Shop {
    @Override
    public void sell() {
        System.out.println("电子产品");
    }

    public void ad(){
        System.out.println("买东西上京东");
    }
}
