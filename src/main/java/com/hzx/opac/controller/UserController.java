package com.hzx.opac.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzx.opac.api.HttpResult;
import com.hzx.opac.api.ResultCode;
import com.hzx.opac.domain.User;
import com.hzx.opac.service.UserService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();
//    private Logger logger = Logger.getLogger(UserController.class);


	@RequestMapping(value="/login",method={RequestMethod.GET})
	@ResponseBody public HttpResult login(String username, String password) {
        HttpResult<User> frame = new HttpResult<User>();
        User user = userService.doLogin(username, password);
        if (user == null) {
            frame.setError_code(ResultCode.PASSWORD_ERROR);
            return frame;
        }
//        logger.info("login success! userID = " + user.getUserId());
        frame.setResult(user);
        return frame;
	}

    /**
     * 获取特定用户的信息
     * @param userId
     * @return
     */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
	public HttpResult userInfo(@PathVariable Integer userId) {
        HttpResult<User> frame = new HttpResult<User>();
        User user = userService.getUserById(userId);
        frame.setError_code(ResultCode.SUCCESS);
        if (user == null) {
            frame.setError_code(ResultCode.USER_NOT_EXIST);
        }
        frame.setResult(user);
        return frame;
    }

    /**
     * 处理注册
     * @param userInfo
     * @return
     */
	@RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
	public HttpResult register(@RequestBody String userInfo){
        HttpResult<User> frame = new HttpResult<User>();
        try {
            User user = objectMapper.readValue(userInfo, User.class);
            user.setUserId(null);
            int ret = userService.doRegister(user);
            if (ret == 0 || user.getUserId() == null) { //存储到数据库失败
                frame.setError_code(ResultCode.SERVER_ERROR);
                return frame;
            }
            //注册成功
            frame.setError_code(ResultCode.SUCCESS);
            frame.setResult(user);
            return frame;  //成功回复给客户端
        } catch (DuplicateKeyException dke){
            //用户名已存在
            frame.setError_code(ResultCode.USER_EXISTED);
        } catch (IOException e) {
            frame.setError_code(ResultCode.SERVER_ERROR);
            e.printStackTrace();
        }
        return frame;
    }

    /**
     * 更改用户的资料
     * @return
     */
    @RequestMapping(value = "/modify")
    @ResponseBody
    public HttpResult modifyInfo(@RequestBody String userInfo) {
        HttpResult<User> frame = new HttpResult<User>();
        try {
            User user = objectMapper.readValue(userInfo, User.class);
            boolean modified = userService.doModify(user);
            if (modified) {
                frame.setError_code(ResultCode.SUCCESS);
            }
        } catch (IOException e) {
            frame.setError_code(ResultCode.SERVER_ERROR);
            e.printStackTrace();
        }
        return frame;
    }
}
