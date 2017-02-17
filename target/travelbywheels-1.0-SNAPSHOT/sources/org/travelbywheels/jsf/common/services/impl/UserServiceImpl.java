package org.travelbywheels.jsf.common.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.travelbywheels.jsf.common.dao.UserDao;
import org.travelbywheels.jsf.common.data.UserData;
import org.travelbywheels.jsf.common.services.UserService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 27/11/2015
 * Time: 16:35
 * Copyright TravelByWheels.
 */

@Service
public class UserServiceImpl implements UserService {

    @Qualifier("userDaoImpl")
    @Autowired
    private UserDao userDao;

    @Override
    public UserData getUserData(String userEmail) {

        return userDao.getUserData(userEmail);
    }

    @Override
    public List<String> getUserRoles(Long userId) {
        return userDao.getUserRoles(userId);
    }

    @Override
    public Boolean isUserEmailExist(String userEmail) {
        return userDao.isUserEmailExist(userEmail);
    }

    @Override
    public UserData registerUser(UserData userData) {
        return userDao.registerUser(userData);
    }
}
