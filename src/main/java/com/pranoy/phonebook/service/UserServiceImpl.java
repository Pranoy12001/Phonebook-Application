package com.pranoy.phonebook.service;

import com.pranoy.phonebook.dao.BaseDAO;
import com.pranoy.phonebook.dao.UserDAO;
import com.pranoy.phonebook.domain.User;
import com.pranoy.phonebook.exception.UserBlockedException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pranoy
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService{
    
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User u) {
       userDAO.save(u);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
