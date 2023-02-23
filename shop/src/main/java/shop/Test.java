package shop;

import shop.customer.Customer;
import shop.shopImpl.TMShop;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 13:07
 * 文件描述：
 */
public class Test {
    public static void main(String[] args) {
        Shop tmShop = new TMShop();
        Customer customer1 = new Customer();
        customer1.buy(tmShop);

    }
}
