package com.ease.service;

import com.ease.model.PurItem;

import java.math.BigDecimal;
import java.util.List;

public interface PurItemService {
    /**
     * 获取所有已购买商品
     *
     * @return
     */
    List<PurItem> getAllPurItems();

    /**
     * 根据商品id，购买商品
     *
     * @param id
     * @return
     */
    Long addPurItem(Long id);

    /**
     * 根据商品详情id获取价格
     *
     * @param contentId
     * @return
     */
    BigDecimal getBuyPriceByDetailId(Long contentId);
}
