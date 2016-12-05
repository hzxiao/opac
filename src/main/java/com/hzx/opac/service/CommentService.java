package com.hzx.opac.service;

import com.hzx.opac.domain.Comment;

public interface CommentService {
    int add(Comment comment);

    Comment getCommentById(Integer id);

    int deleteById(Integer id);

    int update(Comment comment);
}
