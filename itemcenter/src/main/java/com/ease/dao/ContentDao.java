package com.ease.dao;

import com.ease.model.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao {
    List<Content> selectAllContent();

    List<Content> selectContentIsSale();
}
