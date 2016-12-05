package com.hzx.opac.service;

import com.hzx.opac.domain.Answer;

public interface AnswerService {
    Answer getAnswerById(Integer id);

    int add(Answer answer);

    int update(Answer answer);

    int deleteById(Integer id);
}
