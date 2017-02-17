package org.travelbywheels.jsf.common.services;

import org.travelbywheels.jsf.common.data.UserData;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 27/11/2015
 * Time: 16:35
 * Copyright TravelByWheels.
 */
public interface UserService {

    public UserData getUserData(String userEmail);

    public List<String> getUserRoles(Long userId);

    public Boolean isUserEmailExist(String userEmail);

    public UserData registerUser(UserData userData);
}
