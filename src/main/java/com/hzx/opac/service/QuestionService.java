package com.hzx.opac.service;

import com.hzx.opac.domain.Question;

public interface QuestionService {

    int insert(Question question);

    Question selectById(int id);

    int deleteById(int id);
}
