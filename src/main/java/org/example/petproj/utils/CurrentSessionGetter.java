package org.example.petproj.utils;


import org.example.petproj.security.entity.UserDets;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentSessionGetter {
    public static UserDets getCurrentSession(){
        return (UserDets) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
