package org.travelbywheels.jsf.common.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.travelbywheels.jsf.common.beans.LoginRegisterBean;
import org.travelbywheels.jsf.common.data.PersonData;
import org.travelbywheels.jsf.common.data.UserData;
import org.travelbywheels.jsf.common.services.UserLoginRegisterService;
import org.travelbywheels.jsf.common.services.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 23/11/2015
 * Time: 17:27
 * Copyright TravelByWheels.
 */

@Service
public class UserLoginRegisterServiceImpl implements UserLoginRegisterService {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(UserLoginRegisterServiceImpl.class);


    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        LOG.info("Loading user for email : "+ email);

        UserData userData = userService.getUserData(email);

        if (userData == null) {
            LOG.info("UserData " + email + " not found");
            throw new UsernameNotFoundException("UserData " + email + " not found");
        }

        LOG.info("Found User with id : " + userData.getUserId());
        LOG.info("Person : " + userData.getPersonDataByUserId().toString());

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<String> roles = userService.getUserRoles(userData.getUserId());
        for (String role : roles){
            authorities.add(new SimpleGrantedAuthority(role));
        }

        LOG.info("Roles are set for user");

        return new User(email, userData.getUserPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
    }

    public void loadLoginBean(LoginRegisterBean loginRegisterBean, String username){

        UserData userData = userService.getUserData(username);

        loginRegisterBean.setEmail(userData.getUserEmail());
        PersonData personData = userData.getPersonDataByUserId();
        if(personData != null){
            loginRegisterBean.setFirstName(personData.getFirstName());
            loginRegisterBean.setLastName(personData.getLastName());

            if (personData.getFirstName() != null & personData.getLastName() != null){
                loginRegisterBean.setFullName(personData.getFirstName()+" "+personData.getLastName());
            } else if(personData.getFirstName() == null & personData.getLastName() != null){
                loginRegisterBean.setFullName(personData.getLastName());
            } else if(personData.getLastName() == null & personData.getFirstName() != null){
                loginRegisterBean.setFullName(personData.getFirstName());
            } else {
                loginRegisterBean.setFullName(userData.getUserEmail());;
            }
        }

    }

    public void loadUserData(UserData userData, LoginRegisterBean loginRegisterBean){
        userData.setUserEmail(loginRegisterBean.getEmail());
        userData.setUserPassword(loginRegisterBean.getPassword());

        PersonData personData = new PersonData();
        userData.setPersonDataByUserId(personData);
    }

    @Override
    public Boolean checkIsNewUser(String email) {
        if(userService.isUserEmailExist(email)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserData registerUser(UserData userData) {
        return userService.registerUser(userData);
    }
}
