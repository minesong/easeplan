package com.ease.service.impl;

import com.ease.dao.ContentDao;
import com.ease.model.Content;
import com.ease.service.ContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    public Content getContentDetailById(Long contentId) {
        return contentDao.selectContentDetailById(contentId);
    }

    public Boolean updateContentAndDetailById(Content content) {
        if (content == null || content.getId() == null) {
            return false;
        }
        content.setModifyTime(new Date());
        content.setIsDelete((short) 0);
        contentDao.updateContentDetailById(content);
        //参数传递过来的content id 是detail Id 不是简略版content id
        //注意contentId 和 detailId 不是一个ID！，更新时需要查询contend id
        Content tmp = contentDao.selectContentByDetailId(content.getId());
        content.setId(tmp.getId());
        contentDao.updateContentById(content);

        return true;
    }

    public Long addContentAndDetail(Content content) {
        if (content == null) {
            return 0L;
        }
        content.setCreateTime(new Date());
        content.setModifyTime(new Date());
        content.setIsDelete((short) 0);
        content.setIsSale((short) 1);
        contentDao.addContentDetail(content);
        content.setDetailId(content.getId());
        content.setId(null);
        contentDao.addContent(content);
        return content.getDetailId();
    }

    @Override
    public Integer deleteItem(Long id) {
        if (id == null) {
            return 0;
        }
        contentDao.deleteContentDetailById(id);
        Integer res = contentDao.deleteContentByDetailId(id);
        return res;
    }
}
