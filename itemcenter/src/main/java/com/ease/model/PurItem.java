package com.ease.model;

import com.ease.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

public class PurItem {
    private Long id;
    private String imageURL;
    private String title;
    private BigDecimal price;
    private Date createTime;
    private Long detailId;
    private Short isDelete;
    private String buiedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public String getBuiedTime() {
        return DateUtils.parseTime(this.createTime);
    }

    public void setBuiedTime(String buiedTime) {
        this.buiedTime = DateUtils.parseTime(this.createTime);
    }
}
