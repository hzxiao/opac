package com.hzx.opac.persistence;

import com.hzx.opac.domain.Question;

/**
 * Created by hz on 16-12-3.
 */
public interface QuestionMapper {


    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}
