package com.hzx.opac.controller;

import com.hzx.opac.domain.User;
import com.hzx.opac.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {


    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


	@RequestMapping(value="/login",method={RequestMethod.GET})
	@ResponseBody
	public String login() {
        User user = userMapper.selectByPrimaryKey(1);

		return "user/login";
	}
}
