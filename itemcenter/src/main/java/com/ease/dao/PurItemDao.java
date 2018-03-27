package com.ease.dao;

import com.ease.model.PurItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PurItemDao {
    List<PurItem> selectAllPurItems();

    Long insertPurItem(@Param("purItem") PurItem purItem);

    BigDecimal selectBuyPriceByDetailId(@Param("detailId")Long detailId);
}
