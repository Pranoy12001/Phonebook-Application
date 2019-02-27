package com.pranoy.phonebook.service;

import com.pranoy.phonebook.domain.Contact;
import java.util.List;

/**
 *
 * @author Pranoy
 */
public interface ContactService {

    public void save(Contact c);

    public void update(Contact c);

    public void delete(Integer contactId);

    public void delete(Integer[] contactIds);

    /**
     * This method returns all contacts of user(User who logged in).
     *
     * @param userId
     * @return
     */
    public List<Contact> findUserContact(Integer userId);

    /**
     * This method search contact for user(userId) based on given
     * free-text-criteria.
     *
     * @param userId
     * @param txt
     * @return
     */
    public List<Contact> findUserContact(Integer userId, String txt);

}
