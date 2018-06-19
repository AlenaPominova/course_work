package ru.vsu.amm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.IDao;
import ru.vsu.amm.model.Role;

import javax.sql.DataSource;
import java.util.List;

/**
 * CClass for access to db {@link Role}
 * @author Alena Pominova
 * @version 1.0
 */
@Component("RoleDaoImpl")
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

    @Override
    public Role update(Role obj) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
