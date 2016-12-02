package com.hzx.opac.domain;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Integer revieverId;

    private Integer answerId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRevieverId() {
        return revieverId;
    }

    public void setRevieverId(Integer revieverId) {
        this.revieverId = revieverId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}