package com.ease.service.impl;

import com.ease.dao.ContentDao;
import com.ease.dao.PurItemDao;
import com.ease.model.Content;
import com.ease.model.PurItem;
import com.ease.service.PurItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurItemServiceImpl implements PurItemService {
    @Resource
    private PurItemDao purItemDao;
    @Resource
    private ContentDao contentDao;

    public List<PurItem> getAllPurItems() {
        return purItemDao.selectAllPurItems();
    }
    @Transactional(rollbackFor=Exception.class)
    public Long addPurItem(Long id) {
        if (id == null) {
            return 0L;
        }
        Content contentDetail = contentDao.selectContentDetailById(id);
        if (contentDetail == null) {
            return 0L;
        }
        PurItem purItem = new PurItem();
        purItem.setImageURL(contentDetail.getImageURL());
        purItem.setTitle(contentDetail.getTitle());
        purItem.setPrice(contentDetail.getPrice());
        purItem.setDetailId(id);
        purItem.setIsDelete((short) 0);
        purItem.setCreateTime(new Date());
        //res 为0 或者 1 1为成功
        Long res = purItemDao.insertPurItem(purItem);
        contentDao.updateIsSaleInContentByDetailId(id);
        contentDao.updateIsSaleInContentDetailById(id);
        return purItem.getId();
    }
    
    public BigDecimal getBuyPriceByDetailId(Long detailId) {
        return purItemDao.selectBuyPriceByDetailId(detailId);
    }
}
