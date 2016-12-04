package com.hzx.opac.service.impl;

import com.hzx.opac.domain.Question;
import com.hzx.opac.persistence.QuestionMapper;
import com.hzx.opac.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper mapper;

    @Override
    public int insert(Question question) {
        return mapper.insert(question);
    }

    @Override
    public Question selectById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
