package com.scm.scm20.services;
import com.scm.scm20.entities.User;
import java.util.*;
import java.util.Optional;
public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String id);
   Optional <User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();
}
