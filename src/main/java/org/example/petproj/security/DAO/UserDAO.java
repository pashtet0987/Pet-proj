package org.example.petproj.security.DAO;

import org.example.petproj.security.entity.UserDets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserDets, Long> {
    UserDets findByPhoneNumber(String phoneNumber);
}
