package com.pranoy.phonebook.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author Pranoy
 */
public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSrc(DataSource ds) {
        super.setDataSource(ds);
    }
}
