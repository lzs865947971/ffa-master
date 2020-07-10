package com.ffa.utils;

import com.ffa.po.UserInf;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserInfUtils {
    public static UserInf getCurrentUser() {
        return ((UserInf) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
