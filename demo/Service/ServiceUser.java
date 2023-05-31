package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.User;
import com.example.demo.Repository.RepositoryPlace;
import com.example.demo.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUser {

    private final RepositoryUser repositoryUser;



    public List<User> getAllUser() {
        return repositoryUser.findAll();

    }
    public void addUser(User user){
       repositoryUser.save(user);

    }
    public void updateUser(User user,Integer id) {
        User user1 = repositoryUser.getReferenceById(id);
        if (user1 == null) {
            throw new ApiException("customer not found");
        }

        user1.setName(user.getName());
        repositoryUser.save(user1);
    }

    public void deleteUser(Integer id){
        User user=repositoryUser.getReferenceById(id);
        if(user==null){
            throw new ApiException("student not found");
        }

        repositoryUser.delete(user);
    }
    public User getUserByHoppy(String hoppy ){
        User user=repositoryUser.findUserByHoppy(hoppy);
        if (user==null) {
            throw new ApiException("user not found");
        }
        return user;
    }
}

