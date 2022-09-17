package dao;

import az.company.booking_project.DAO.UserDao;
import az.company.booking_project.entities.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest extends UserDao {
    @Test
    void findAll() {
        User user= new User("gadimov", "aAa12!+b");
        create(user);
        ArrayList<User> users= new ArrayList<>();
        users.add(user);
        assertEquals(users,getAll());
    }


    @Test
    void findById() throws IOException, ClassNotFoundException {
        User user= new User("gadimov", "aAa12!+b");
        create(user);
        assertEquals(Optional.of(user), getById(user.getId()));
    }


    @Test
    void add() {
        User user= new User("gadimov", "aAa12!+b");

        create(user);
        assertTrue(create(user));
    }

    @Test
    void remove() {
        User user= new User("gadimov", "aAa12!+b");

        create(user);
        assertTrue(delete(user.getId()));
    }


}