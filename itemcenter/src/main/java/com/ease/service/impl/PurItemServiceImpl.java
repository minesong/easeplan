package com.ease.service.impl;

import com.ease.dao.PurItemDao;
import com.ease.model.PurItem;
import com.ease.service.PurItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PurItemServiceImpl implements PurItemService {
    @Resource
    private PurItemDao purItemDao;

    public List<PurItem> getAllPurItems() {
        return purItemDao.selectAllPurItems();
    }

    public Long addPurItem(PurItem purItem) {
        if (purItem == null) {
            return 0L;
        }
        purItem.setIsDelete((short)0);
        purItem.setCreateTime(new Date());
        return purItemDao.insertPurItem(purItem);
    }
}
