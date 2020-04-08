package ru.yura.web.dao;


import org.springframework.stereotype.Repository;
import ru.yura.web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User model) {
        entityManager.persist(model);
    }

    @Override
    public User update(User model) {
        return entityManager.merge(model);
    }

    @Override
    public User findModelByName(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.email = :email");
        query.setParameter("email", email);
        User user = (User) query.getSingleResult();
        return user == null ? null : user;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> findAll() {

        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User findById(Long id) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.id = :id");
        query.setParameter("id", id);
        User user = (User) query.getSingleResult();
        return user == null ? null : user;
    }

    public void drop() {
    }

    @Override
    public void create() {
    }
}
