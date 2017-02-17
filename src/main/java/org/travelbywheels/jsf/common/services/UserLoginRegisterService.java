package org.travelbywheels.jsf.common.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.travelbywheels.jsf.common.beans.LoginRegisterBean;
import org.travelbywheels.jsf.common.data.UserData;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 23/11/2015
 * Time: 17:18
 * Copyright TravelByWheels.
 */

public interface UserLoginRegisterService extends UserDetailsService {

    public void loadLoginBean(LoginRegisterBean loginRegisterBean, String email);

    public Boolean checkIsNewUser(String email);

    public UserData registerUser(UserData userData);

    public void loadUserData(UserData userData, LoginRegisterBean loginRegisterBean);
}
