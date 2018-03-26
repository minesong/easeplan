package com.ease.dao;

import com.ease.model.Content;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao {
    List<Content> selectAllContent();

    List<Content> selectContentIsSale();

    Content selectContentDetailById(@Param("contentId") Long contentId);

    Integer updateContentDetailById(@Param("contentDetail") Content contentDetail);

    Integer updateContentById(@Param("con") Content con);

    Integer addContentDetail(@Param("contentDetail") Content contentDetail);

    Integer addContent(@Param("con") Content con);

    Content selectContentByDetailId(@Param("detailId") Long detailId);

    Integer updateIsSaleInContentByDetailId(@Param("detailId") Long detailId);

    Integer updateIsSaleInContentDetailById(@Param("detailId") Long detailId);
}
