package com.hzx.opac.service.impl;

import com.hzx.opac.domain.Comment;
import com.hzx.opac.persistence.CommentMapper;
import com.hzx.opac.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int add(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
