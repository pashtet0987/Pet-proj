package org.example.petproj.security.services;


import org.example.petproj.security.DAO.UserDAO;
import org.example.petproj.security.entity.UserDets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder encoder;

    public boolean createUser(UserDets userDets){
        if(userDAO.findByPhoneNumber(userDets.getPhoneNumber()) != null){
            return false;
        }
        userDets.setPassword(encoder.encode(userDets.getPassword()));
        userDets.setActive(true);
//        userDets.getRoles().add(Role.ROLE_USER);
        userDAO.save(userDets);
        return true;
    }

    public UserDets findAllByPhoneNumber(String phoneNumber){
        return userDAO.findByPhoneNumber(phoneNumber);
    }
}
