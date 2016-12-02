package com.hzx.opac;

import com.hzx.opac.domain.QuestionType;
import com.hzx.opac.service.QuestionTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestQuestionType {
    @Resource
    private QuestionTypeService questionTypeService;

    @Test
    public void Test(){
        QuestionType type = new QuestionType();
        type.setTypeDesc("生活");
        questionTypeService.insert(type);

        QuestionType type1 = questionTypeService.selectById(1);
        if (type1 != null) {
            System.out.println(type1.getQuestionTypeId() + "---" + type1.getTypeDesc());
        } else {
            System.out.println("type1 is null");
        }

        QuestionType type2 = questionTypeService.selectByDesc("生活");
        if (type2 != null) {
            System.out.println(type2.getQuestionTypeId() + "---" + type2.getTypeDesc());
        } else {
            System.out.println("type2 is null");
        }
    }
}
