package com.pranoy.phonebook.service;

import com.pranoy.phonebook.dao.BaseDAO;
import com.pranoy.phonebook.dao.ContactDAO;
import com.pranoy.phonebook.domain.Contact;
import com.pranoy.phonebook.rm.ContactRowMapper;
import com.pranoy.phonebook.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pranoy
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer contactId) {
        contactDAO.delete(contactId);
    }

    @Override
    public void delete(Integer[] contactIds) {
        String ids = StringUtils.toCommaSeperatedString(contactIds);
        String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remarks"
                + " FROM contact WHERE userId= ? AND "
                + "(name LIKE '%" + txt + "%' OR remarks LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" + txt + "%' OR address LIKE '%" + txt + "%')";

        return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
    }

    @Override
    public Contact findByContactId(Integer contactId) {
        return contactDAO.findById(contactId);
    }

}
