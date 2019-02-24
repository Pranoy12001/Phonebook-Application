package com.pranoy.phonebook.dao;

import com.pranoy.phonebook.domain.User;
import java.util.List;

/**
 *
 * @author Pranoy
 */
public interface UserDAO {

    public void save(User u);

    public void update(User u);

    public void delete(Integer userId);

    public void findById(Integer userId);

    public List<User> findAll();

    public List<User> findByProperty(String propName, Object propValue);
}
