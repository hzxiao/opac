package com.hzx.opac.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzx.opac.api.ApiField;
import com.hzx.opac.api.UserFrame;
import com.hzx.opac.domain.Question;
import com.hzx.opac.domain.QuestionType;
import com.hzx.opac.domain.User;
import com.hzx.opac.service.QuestionTypeService;
import com.hzx.opac.service.UserService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();
//    private Logger logger = Logger.getLogger(UserController.class);


    @Autowired
    private QuestionTypeService questionTypeService;

	@RequestMapping(value="/login",method={RequestMethod.GET})
	@ResponseBody public UserFrame login(String username, String password) {
        UserFrame frame = new UserFrame();
        User user = userService.doLogin(username, password);
        if (user == null) {
            frame.setError_code(ApiField.LOGIN_FIAL);
            return frame;
        }
//        logger.info("login success! userID = " + user.getUserId());
        try {
            String userInfo = objectMapper.writeValueAsString(user);
            frame.setResult(userInfo);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return frame;
	}

	@RequestMapping(value = "register")
    @ResponseBody
	public UserFrame register(){
        QuestionType type = new QuestionType();
        type.setTypeDesc("life");
        questionTypeService.insert(type);

        QuestionType type1 = questionTypeService.selectById(2);
        if (type1 != null) {
            System.out.println(type1.getQuestionTypeId() + "---" + type1.getTypeDesc());
        } else {
            System.out.println("type1 is null");
        }

        QuestionType type2 = questionTypeService.selectByDesc("life");
        if (type2 != null) {
            System.out.println(type2.getQuestionTypeId() + "---" + type2.getTypeDesc());
        } else {
            System.out.println("type2 is null");
        }
//        questionTypeService.deleteById(1);
        List<QuestionType> list = questionTypeService.list();
        System.out.println(list.size());
        return null;
    }
}
