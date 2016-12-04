package com.hzx.opac.service.impl;

import com.hzx.opac.domain.User;
import com.hzx.opac.persistence.UserMapper;
import com.hzx.opac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hz on 16-11-28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User doLogin(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return null;
        }
        if (password.equals(user.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public int doRegister(User newUser) {
        return userMapper.insert(newUser);
    }

    @Override
    public boolean doModify(User user) {
        int ret = userMapper.updateByPrimaryKeySelective(user);
        return ret != 0;
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
