package org.enote.services;

import org.springframework.util.DigestUtils;

public class UserService {

    public String getEncodedPassword(String password) {
        return DigestUtils.	md5DigestAsHex(password.getBytes());
    }
}
