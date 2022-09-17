package service;

import az.company.booking_project.entities.User;
import az.company.booking_project.Services.UserService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends UserService {
@Test
    public void getUser1() {
    User user= new User("gadimov", "aAa12!+b");
    createNewUser("gadimov", "aAa12!+b");
        assertEquals(Optional.of(user), get("gadimov", "aAa12!+b"));
    }
    @Test
    void add2() {
        assertFalse(createNewUser("gadimov", "aAa12!+b"));
    }


}