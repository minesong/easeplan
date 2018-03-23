package com.ease.service;

import com.ease.model.Content;

import java.util.List;

public interface ContentService {
    List<Content> getAllContent();

    List<Content> getContentIsSale();

    Content getContentDetailById(Long contentId);

    Boolean updateContentAndDetailById(Content content);

    Long addContentAndDetail(Content content);
}
