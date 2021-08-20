package spring_crud.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_crud.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    @Transactional
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
