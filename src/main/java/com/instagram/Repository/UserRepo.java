package com.instagram.Repository;

import com.instagram.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User save(User user);
    User findByUserId(String userId);

}
