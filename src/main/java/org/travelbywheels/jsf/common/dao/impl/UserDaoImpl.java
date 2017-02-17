package org.travelbywheels.jsf.common.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.travelbywheels.jsf.common.beans.LoginRegisterBean;
import org.travelbywheels.jsf.common.dao.UserDao;
import org.travelbywheels.jsf.common.data.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 23/11/2015
 * Time: 17:40
 * Copyright TravelByWheels.
 */

@Repository
public class UserDaoImpl implements UserDao {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserData getUserData(String userEmail) {

        UserData userData = restTemplate.getForObject("http://api.travelbywheels.com/api/user-services/"+ userEmail +"/", UserData.class);

        return userData;
    }

    @Override
    public List<String> getUserRoles(Long userId) {

        List<String> roles = new ArrayList<String>();
        roles.add("ROLE_Traveller");
        return roles;
    }

    @Override
    public Boolean isUserEmailExist(String userEmail) {
        Boolean isUserEmailExist = restTemplate.getForObject("http://api.travelbywheels.com/api/user-services/"+ userEmail +"/check", Boolean.class);
        return isUserEmailExist;
    }

    @Override
    public UserData registerUser(UserData userData) {
            userData = restTemplate.postForObject("http://api.travelbywheels.com/api/user-services/register-user", userData, UserData.class);

        return userData;
    }
}
