package ru.yura.web.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yura.web.dao.RoleDao;
import ru.yura.web.dao.UserDao;
import ru.yura.web.model.Role;
import ru.yura.web.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    final private
    UserDao userDao;

    final private
    RoleDao roleDao;


    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void add(User model, Long id) {
        userDao.add(model);
        Role role = roleDao.findById(id);
        model.addRoles(role);
    }

    @Transactional
    @Override
    public User update(User model) {
        Long[] ids = findIds(model);
        User user = userDao.update(model);
        insideRoles(user, ids);
        return user;
    }

    private Long[] findIds(User model) {
        List<Role> roles = model.getRoles();
        model.setRoles(new ArrayList<>());
        Long[] ids = new Long[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            ids[i] = roles.get(i).getId();
        }
        return ids;
    }

    private void insideRoles(User model, Long[] ids) {
        Set<Role> newRoles = new HashSet<>();
        for (Long id : ids) {
            Role role = roleDao.findById(id);
            newRoles.add(role);
        }
        model.setRoles(new ArrayList<>(newRoles));
    }


    @Transactional(readOnly = true)
    @Override
    public User findModelByName(String name) {

        return userDao.findModelByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {

        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }


    @Override
    public void drop() {
        userDao.drop();
    }


    @Override
    public void create() {
        userDao.create();
    }
}
