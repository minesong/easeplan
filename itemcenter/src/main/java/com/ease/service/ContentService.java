package com.ease.service;

import com.ease.model.Content;

import java.util.List;

public interface ContentService {
    /**
     * 获取所有的内容商品
     *
     * @return
     */
    List<Content> getAllContent();

    /**
     * 获取在售（未购买）商品，
     *
     * @return
     */
    List<Content> getContentIsSale();

    /**
     * 根据内容商品ID，获取内容商品
     *
     * @param contentId
     * @return
     */
    Content getContentDetailById(Long contentId);

    /**
     * 更新内容 以及详情
     *
     * @param content
     * @return 事否更新成功
     */
    Boolean updateContentAndDetailById(Content content);

    /**
     * 添加内容以及详情
     *
     * @param content
     * @return
     */
    Long addContentAndDetail(Content content);

    /**
     * 根据内容商品Id 删除内容以及详情
     *
     * @param id
     * @return 返回值是0 或者1
     */
    Integer deleteItem(Long id);
}
