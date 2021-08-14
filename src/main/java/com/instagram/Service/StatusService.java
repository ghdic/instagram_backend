package com.instagram.Service;

import com.instagram.Repository.StatusRepo;
import com.instagram.model.Status;
import com.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StatusService {

    @Autowired
    StatusRepo statusRepo;

    @Autowired
    UserService userService;

    public Status submitDataIntoDB(Status status) {
        return statusRepo.save(status);
    }

    public ArrayList<Status> retrieveStatus() {
        ArrayList<Status> statusList = statusRepo.findAll();

        for(int i = 0; i < statusList.size(); i++) {
            Status status = statusList.get(i);
            User user = userService.displayUserMetaData(status.getUserId());
            if(user != null)
                status.setUserName(user.getUserName());
        }

        return statusList;
    }
}
