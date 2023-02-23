package com.itwen.dao;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/23 16:04
 * 文件描述：
 */
public interface BookDao {
    /**
     * 根据图书的id查询图书的价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);
    /**
     * 根据图书的id更新库存
     * @param bookId
     */
    void updateStock(Integer bookId);
    /**
     * 更新用户的余额
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
