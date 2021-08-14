package com.instagram.Repository;

import com.instagram.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StatusRepo extends CrudRepository<Status, Integer> {
    Status save(Status status);
    ArrayList<Status> findAll();
}
