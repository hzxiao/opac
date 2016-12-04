package com.hzx.opac.service;

import com.hzx.opac.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User doLogin(String username, String password);

    int doRegister(User newUser);

    boolean doModify(User user);

    User getUserById(int userId);

    User getUserByUsername(String username);
}
