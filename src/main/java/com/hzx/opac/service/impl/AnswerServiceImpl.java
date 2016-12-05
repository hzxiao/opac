package com.hzx.opac.service.impl;

import com.hzx.opac.domain.Answer;
import com.hzx.opac.persistence.AnswerMapper;
import com.hzx.opac.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Answer getAnswerById(Integer id) {
        return answerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Answer answer) {
        return answerMapper.insert(answer);
    }

    @Override
    public int update(Answer answer) {
        return answerMapper.updateByPrimaryKeySelective(answer);
    }

    @Override
    public int deleteById(Integer id) {
        return answerMapper.deleteByPrimaryKey(id);
    }
}
