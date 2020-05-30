package com.spring.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 2020/5/30
 */
public interface RowDao {

    Object mapRow(ResultSet set, int index) throws SQLException;
}
