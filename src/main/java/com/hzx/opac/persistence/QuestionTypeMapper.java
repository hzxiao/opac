package com.hzx.opac.persistence;

import com.hzx.opac.domain.QuestionType;



public interface QuestionTypeMapper {

    int deleteByPrimaryKey(Integer questionTypeId);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    QuestionType selectByPrimaryKey(Integer questionTypeId);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}
