package it.univaq.f4i.iw.examples.data.dao;

import it.univaq.f4i.iw.examples.data.models.User;
import it.univaq.f4i.iw.examples.data.models.Role;
import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getUsersByRole(Role role);
    void saveUser(User user);
    void deleteUser(int id);
}