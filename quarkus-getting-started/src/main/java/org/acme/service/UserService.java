package org.acme.service;


import org.acme.model.*;
import org.acme.repository.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.listAll();
    }

    @Transactional
    public void addUser(User user){
        userRepository.persist(user);
    }

}