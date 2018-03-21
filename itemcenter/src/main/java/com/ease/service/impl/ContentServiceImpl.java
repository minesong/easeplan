package com.ease.service.impl;

import com.ease.dao.ContentDao;
import com.ease.model.Content;
import com.ease.service.ContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentDao contentDao;

    public List<Content> getAllContent() {
        return contentDao.selectAllContent();
    }

    public List<Content> getContentIsSale() {
        return contentDao.selectContentIsSale();
    }
}
