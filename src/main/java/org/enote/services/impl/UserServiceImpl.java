package org.enote.services.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.enote.AppConfig;
import org.enote.domain.User;
import org.enote.repos.UserRepo;
import org.enote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String PASSWORD_SHA256 = "SHA-256";

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Environment environment;

    @Override
    public User saveUser(User user) throws Exception {
        if (user.getId() == null || !userRepo.existsById(user.getId())) {
            // attempt to encode password
            user.setPassword(getEncodedPassword(user.getPassword()));
            return userRepo.save(user);
        }
        return user;
    }

    @Override
    public User deactivateUser(int userId) throws Exception {
        Optional<User> user = userRepo.findById(userId);

        if (user.isPresent()) {
            user.get().setActive(false); // deactivating the user
            return userRepo.save(user.get());
        }
        throw new Exception("Error: could not find the specified user.");
    }

    /**
     * Encodes password to md5/SHA-256 based on the active Spring profile
     *
     * @param password user password
     * @return encoded password
     * @throws Exception
     */
    private String getEncodedPassword(String password) throws Exception {
        if (AppConfig.getProfile(environment).equals(AppConfig.PROFILE_DEV)) {
            try {
                MessageDigest digest = MessageDigest.getInstance(PASSWORD_SHA256);
                return ArrayUtils.toString(digest.digest(password.getBytes(StandardCharsets.UTF_8)));
            } catch (NoSuchAlgorithmException ex) {
                throw new Exception("Error: user password cannot be encoded.");
            }
        }
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
