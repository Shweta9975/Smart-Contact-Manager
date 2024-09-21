package com.scm.scm20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scm.scm20.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository <User ,String> {

Optional<User> findByEmail(String email);
Optional<User>findByEmailAndPassword(String email,String password);
}
