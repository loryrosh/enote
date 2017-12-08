package org.enote.services.impl;

import org.springframework.util.DigestUtils;

public class UserServiceImpl {

    public String getEncodedPassword(String password) {
        return DigestUtils.	md5DigestAsHex(password.getBytes());
    }
}
