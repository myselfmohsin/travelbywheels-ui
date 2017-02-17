package org.travelbywheels.jsf.common.dao;

import org.travelbywheels.jsf.common.data.UserData;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 23/11/2015
 * Time: 17:39
 * Copyright TravelByWheels.
 */
public interface UserDao {

    public UserData getUserData(String userEmail);

    public List<String> getUserRoles(Long userId);

    public Boolean isUserEmailExist(String userEmail);

    public UserData registerUser(UserData userData);
}
