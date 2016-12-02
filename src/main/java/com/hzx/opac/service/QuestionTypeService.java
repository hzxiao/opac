package com.hzx.opac.service;

import com.hzx.opac.domain.QuestionType;

import java.util.List;

public interface QuestionTypeService {
    int insert(QuestionType record);


    QuestionType selectById(int id);

    QuestionType selectByDesc(String desc);

    int update(QuestionType record);

    int deleteById(int id);

    List<QuestionType> list();

}
