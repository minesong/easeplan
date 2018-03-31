package com.ease.dao;

import com.ease.model.Content;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ContentDao {
    /**
     * 查询所有商品
     *
     * @return
     */
    List<Content> selectAllContent();

    /**
     * 查询所有（未购买）在售商品
     *
     * @return
     */
    List<Content> selectContentIsSale();

    /**
     * 根据ID 获取商品详情
     *
     * @param con
     * @return
     */
    Content selectContentDetailById(@Param("contentId") Long contentId);

    /**
     * 更新内容商品详情
     *
     * @param con
     * @return
     */
    Integer updateContentDetailById(@Param("contentDetail") Content contentDetail);

    /**
     * 更新内容商品
     *
     * @param con
     * @return
     */
    Integer updateContentById(@Param("con") Content con);

    /**
     * 添加内容商品详情
     *
     * @param con
     * @return
     */
    Integer addContentDetail(@Param("contentDetail") Content contentDetail);

    /**
     * 往数据库中添加内容商品
     *
     * @param con
     * @return 返回值是0 或者1
     */
    Integer addContent(@Param("con") Content con);

    /**
     * 从数据库中根据详情Id获取内容商品
     *
     * @param detailId
     * @return
     */
    Content selectContentByDetailId(@Param("detailId") Long detailId);

    /**
     * 根据详情Id，更新数据库内容商品在售状态
     *
     * @param detailId
     * @return 返回值是0 或者1
     */
    Integer updateIsSaleInContentByDetailId(@Param("detailId") Long detailId);

    /**
     * 根据详情Id，更新数据库商品详情在售状态
     *
     * @param detailId
     * @return 返回值是0 或者1
     */
    Integer updateIsSaleInContentDetailById(@Param("detailId") Long detailId);

    /**
     * 删除详情
     *
     * @param content
     * @return 返回值是0 或者1
     */
    Integer deleteContentDetailById(@Param("detailId") Long detailId);

    /**
     * 根据内容商品Id 删除内容
     *
     * @param id
     * @return 返回值是0 或者1
     */
    Integer deleteContentByDetailId(@Param("detailId") Long detailId);

}
