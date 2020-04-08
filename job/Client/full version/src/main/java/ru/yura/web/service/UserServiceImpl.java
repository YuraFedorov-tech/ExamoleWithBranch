package ru.yura.web.service;


import org.springframework.stereotype.Service;
import ru.yura.web.model.User;
import ru.yura.web.serviceRest.RestServiceImpl;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final
    RestServiceImpl restService;

    public UserServiceImpl(RestServiceImpl restService) {
        this.restService = restService;
    }

    @Override
    public User findModelByName(String name) {
        return restService.findModelByName(name);
    }


    @Override
    public List<User> findAll() {
        return restService.findAll();
    }

    @Override
    public User delete(User model) {
        return restService.delete(model);
    }

    @Override
    public User add(User model, Long ids) {
       return restService.add(model,ids);
    }

    @Override
    public User update(User model, Long[] ids) {
        return restService.update(model,ids);
    }
    @Override
    public User findById(Long id) {
        return restService.findById(id);
    }








    @Override
    public void drop() {

    }

    @Override
    public void create() {

    }

    @Override
    public void print() {

    }
}
