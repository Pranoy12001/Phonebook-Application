package com.pranoy.phonebook.service;

import com.pranoy.phonebook.domain.User;
import com.pranoy.phonebook.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author Pranoy
 */
public interface UserService {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;

    public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_USER = 2;
    
    /**
     * This method handle the user registration task.
     *
     * @param u
     */
    public void register(User u);

    /**
     * This method handles login operation(authentication) using given
     * credentials. It returns User object when success and null when failed.
     *
     * @param loginName
     * @param password
     * @return
     * @throws com.pranoy.phonebook.exception.UserBlockedException when User
     * account is blocked.
     */
    public User login(String loginName, String password) throws UserBlockedException;

    /**
     * Call this method to get Registered users
     *
     * @return
     */
    public List<User> getUserList();

    /**
     * This method change the user login status
     *
     * @param userId
     * @param loginStatus
     */
    public void changeLoginStatus(Integer userId, Integer loginStatus);
}
