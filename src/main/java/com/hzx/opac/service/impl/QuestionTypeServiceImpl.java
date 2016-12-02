package com.hzx.opac.service.impl;

import com.hzx.opac.domain.QuestionType;
import com.hzx.opac.persistence.QuestionTypeMapper;
import com.hzx.opac.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

    @Autowired
    private QuestionTypeMapper mapper;

    @Override
    public int insert(QuestionType record) {
        return mapper.insert(record);
    }

    @Override
    public QuestionType selectById(int id) {
        return mapper.selectByPrimaryKey(new Integer(id));
    }

    @Override
    public QuestionType selectByDesc(String desc) {
        return null;
    }

    @Override
    public int update(QuestionType record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(new Integer(id));
    }

    @Override
    public List<QuestionType> list() {
        return null;
    }
}
