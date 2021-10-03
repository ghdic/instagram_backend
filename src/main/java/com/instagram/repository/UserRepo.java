package com.instagram.repository;

import com.instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User save(User user);
    ArrayList<User> findAll();
    ArrayList<User> findFirst10ByOrderByIdDesc();
    User findByUid(String uid);
}
