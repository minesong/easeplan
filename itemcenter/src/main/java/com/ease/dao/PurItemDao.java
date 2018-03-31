package com.ease.dao;

import com.ease.model.PurItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PurItemDao {
    /**
     * 数据库中获取所有已购买未删除内容商品
     *
     * @return
     */
    List<PurItem> selectAllPurItems();

    /**
     * 往数据库插入购买商品
     *
     * @param purItem
     * @return
     */
    Long insertPurItem(@Param("purItem") PurItem purItem);

    /**
     * 根据商品详情id，从数据库中获取购买价格
     *
     * @param detailId
     * @return
     */
    BigDecimal selectBuyPriceByDetailId(@Param("detailId") Long detailId);
}
