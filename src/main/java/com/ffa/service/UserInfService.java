package com.ffa.service;

import com.ffa.dao.UserInfMapper;
import com.ffa.dao.UserRoleMapper;
import com.ffa.po.UserInf;
import com.ffa.utils.UserInfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfService implements UserDetailsService {

    /**
     *
     */
    @Autowired
    UserInfMapper userInfMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInf userInf = userInfMapper.loadUserByUsername(username);
        if (userInf == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        userInf.setRoles(userInfMapper.getUserRolesById(userInf.getUserId()));
        return userInf;
    }

    public List<UserInf> getAllUsers(String keywords) {
        return userInfMapper.getAllUsers(UserInfUtils.getCurrentUser().getUserId(),keywords);
    }




    @Transactional
    public boolean updateHrRole(Integer uid, Integer[] rids) {
        userRoleMapper.deleteByUserId(uid);
        return userRoleMapper.addRole(uid, rids) == rids.length;
    }

    public Integer deleteUserInfById(Integer id) {
        return userInfMapper.deleteByPrimaryKey(id);
    }

    public List<UserInf> getAllUsersExceptCurrentHr() {
        return userInfMapper.getAllUsersExceptCurrentHr(UserInfUtils.getCurrentUser().getUserId());
    }

    public Integer updateUserInfById(UserInf userInf) {
        return userInfMapper.updateByPrimaryKeySelective(userInf);
    }

    public Integer addUserInf(UserInf userInf) {
        return userInfMapper.insertSelective(userInf);
    }

    public boolean updateHrPasswd(String oldpass, String pass, Integer uid) {
        UserInf userInf = userInfMapper.selectByPrimaryKey(uid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpass, userInf.getPassword())) {
            String encodePass = encoder.encode(pass);
            Integer result = userInfMapper.updatePasswd(uid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

//    public Integer updateUserface(String url, Integer id) {
//        return hrMapper.updateUserface(url, id);
//    }
}
