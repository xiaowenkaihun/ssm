package shop.customer;

import shop.Shop;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 13:07
 * 文件描述：
 */
public class Customer {
    public void buy(Shop shop){
        System.out.println("顾客在"+shop.getClass().getName()+"购买了");
        shop.sell();
    }
}
