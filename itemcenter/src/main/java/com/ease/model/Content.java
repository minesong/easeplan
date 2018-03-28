package com.ease.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class Content {
    private Long id;
    @Size(min = 2, max = 1000, message = "详情长度范围2-1000")
    private String detail;
    @Size(min = 2, max = 140, message = "摘要长度范围2-140")
    private String summary;
    @Size(min = 2, max = 80, message =  "标题长度范围2-80")
    private String title;
    private String imageURL;
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;
    private Short isSale;
    private Date createTime;
    private Date modifyTime;
    private Short isDelete;
    private Long detailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getIsSale() {
        return isSale;
    }

    public void setIsSale(Short isSale) {
        this.isSale = isSale;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
}
