package ru.vsu.amm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.model.Role;

import javax.sql.DataSource;

//TODO: implementation
public class RoleDaoImpl implements IDao<Role> {
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public Role insert(Role obj) {
        return null;
    }

    @Override
    public Role findById(int id) {
        return null;
    }
}
