package com.ease.service;

import com.ease.model.PurItem;

import java.math.BigDecimal;
import java.util.List;

public interface PurItemService {
    List<PurItem> getAllPurItems();

    Long addPurItem(Long id);

    BigDecimal getBuyPriceByDetailId(Long contentId);
}
