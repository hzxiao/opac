package com.hzx.opac.service;

import com.hzx.opac.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User doLogin(String username, String password);

    User doRegister(User newUser);

    boolean doModify(User user);
}
