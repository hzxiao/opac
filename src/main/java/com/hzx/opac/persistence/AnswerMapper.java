package com.hzx.opac.persistence;

import com.hzx.opac.domain.Answer;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}
