package ru.vsu.amm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsu.amm.dao.impl.RoleDaoImpl;
import ru.vsu.amm.dao.impl.UserDaoImpl;
import ru.vsu.amm.model.Role;
import ru.vsu.amm.model.User;
import ru.vsu.amm.services.IService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for busness logic of {@link User}
 * @see IService
 * @author Alena Pominova
 * @version 1.0
 */
@Component("UserService")
public class UserService implements IService<User> {
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private RoleDaoImpl roleDao;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    public UserService(UserDaoImpl userDao, RoleDaoImpl roleDao){
//        this.userDao = userDao;
//        this.roleDao = roleDao;
//    }


    /**
     * method for saving user
     * @see User
     * @see UserDaoImpl
     * @param user
     * @return User
     */
    @Override
    public void save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleDao.findById(2);
        user.setRole(role);
        userDao.insert(user);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void delete(String id) {
        userDao.delete(Integer.valueOf(id));
    }

    @Override
    public User update(User obj) {
        return userDao.update(obj);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
