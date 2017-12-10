package org.enote.services;

import org.enote.domain.User;

public interface UserService {

    /**
     * Sets active user from user profile
     *
     * @param email user email
     * @return active user
     */
    User setActiveUser(String email);

    /**
     * Gets active user from user profile
     *
     * @return active user
     */
    User getActiveUser();

    /**
     * Saves user entity with encoded password
     *
     * @param user user entity
     * @return saved user
     * @throws Exception
     */
    User saveUser(User user) throws Exception;

    /**
     * Deactivates user account
     *
     * @param userId user id
     * @return deactivated user
     */
    User deactivateUser(int userId) throws Exception;
}
