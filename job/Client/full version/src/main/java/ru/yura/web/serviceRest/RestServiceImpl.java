package ru.yura.web.serviceRest;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.yura.web.model.Role;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import java.util.*;

@Service
public class RestServiceImpl implements RestService {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public RestServiceImpl(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = "http://localhost:8080/";
    }



    @Override
    public List<User> findAll() {
        User[] list = restTemplate.getForObject(serverUrl + "admin/admin", User[].class);
        List<User> users = Arrays.asList(list);
        return users;
    }


    @Override
    public User delete(User model) {
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<User> responseEntity
                = restTemplate.exchange(serverUrl + "admin/delete", HttpMethod.POST, requestBody, User.class);
        User user2=responseEntity.getBody();
        return user2;
    }

    @Override
    public User add(User model, Long ids) {
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<User> responseEntity
                = restTemplate.exchange(serverUrl + "admin/add/"+Long.toString(ids), HttpMethod.POST, requestBody, User.class);
        User user=responseEntity.getBody();
        return user;
    }

    @Override
    public User update(User model, Long[] ids) {

        for(Long id:ids){
            model.addRoles(new Role().setId(id));
        }
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<User> responseEntity
                = restTemplate.exchange(serverUrl + "admin/update/", HttpMethod.POST, requestBody, User.class);
        User user=responseEntity.getBody();
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = restTemplate.getForObject(serverUrl+"admin/findUserById/"+id, User.class);
        return user;
    }
    @Override
    public User findModelByName(String name) {
        User user = restTemplate.getForObject(serverUrl+"auth/findUserByName/"+name, User.class);
        return user;
    }










    @Override
    public void drop() {

    }

    @Override
    public void create() {

    }




}
/*    @GetMapping(value = "/getUser/{id}")
    public String getUser(@PathVariable long id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userDetailsService.findUserByID(id));
    }

    @GetMapping(value = "/getAllRoles")
    public Set<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public String delete(@PathVariable long id) throws JsonProcessingException {
        userDetailsService.deleteUserById(id);
        return objectMapper.writeValueAsString("User delete");
    }

    @PutMapping(value = "/addUser")
    public String addUser(@RequestBody User user) throws JsonProcessingException {
        if (user.getName().isEmpty() || user.getLastName().isEmpty() || user.getAge() < 0 || user.getEmail().isEmpty()
                || user.getPassword().isEmpty() || user.getRoles().size() == 0) {
            return objectMapper.writeValueAsString("User not added! Invalid Arguments");
        }
        user.setRoles(roleService.getSomeRolesByNames(user.getRoles()));
        userDetailsService.addUser(user);
        return objectMapper.writeValueAsString("User successfully added");
    }*/