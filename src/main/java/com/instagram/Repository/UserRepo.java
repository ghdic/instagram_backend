package com.instagram.Repository;

import com.instagram.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User save(User user);
    ArrayList<User> findAll();
    ArrayList<User> findFirst10ByOrderByIdDesc();
    User findByUid(String uid);
}
