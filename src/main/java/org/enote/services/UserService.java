package org.enote.services;

import org.springframework.util.DigestUtils;

public interface UserService {

    String getEncodedPassword(String password);
}
