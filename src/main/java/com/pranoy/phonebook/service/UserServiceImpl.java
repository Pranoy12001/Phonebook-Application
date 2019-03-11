package com.pranoy.phonebook.service;

import com.pranoy.phonebook.dao.BaseDAO;
import com.pranoy.phonebook.dao.UserDAO;
import com.pranoy.phonebook.domain.User;
import com.pranoy.phonebook.exception.UserBlockedException;
import com.pranoy.phonebook.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "SELECT userId, name, phone, gmail, address, loginName, role, loginStatus"
                + " WHERE loginName= :loginName AND password = :password";
        Map m = new HashMap();
        m.put("loginName", loginName);
        m.put("password", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
                throw new UserBlockedException("Your account has been blocked. Please contact with admin.");
            }else{
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
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
