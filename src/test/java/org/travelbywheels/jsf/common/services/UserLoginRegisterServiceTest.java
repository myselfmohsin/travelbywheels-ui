package org.travelbywheels.jsf.common.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.travelbywheels.jsf.common.beans.LoginRegisterBean;
import org.travelbywheels.jsf.common.data.PersonData;
import org.travelbywheels.jsf.common.data.UserData;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 27/11/2015
 * Time: 15:41
 * Copyright TravelByWheels.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class UserLoginRegisterServiceTest {

    @Qualifier("userLoginRegisterServiceImpl")
    @Autowired
    private UserLoginRegisterService userLoginRegisterService;

//    @Test
    @Transactional
    @Rollback(false)
    public void testLoadLoginBean(){

        LoginRegisterBean loginRegisterBean = new LoginRegisterBean();

        userLoginRegisterService.loadLoginBean(loginRegisterBean,"mohsin@iintellisys.com");

        System.out.println(" User Name : "+ loginRegisterBean.getFirstName() + " " + loginRegisterBean.getLastName());

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCheckIsNewUser(){

        Boolean check = userLoginRegisterService.checkIsNewUser("myselfmohsin@gmail.com");

        System.out.println(" CheckIsNewUser :"+check);
    }

//    @Test
//    @Transactional
//    @Rollback(false)
    public void testRegisterUser(){

        UserData userData = new UserData();

        userData.setUserEmail("myselfmohsin37@gmail.com");
        userData.setUserPassword("mohsin");

        PersonData personData = new PersonData();
        userData.setPersonDataByUserId(personData);

        UserData registeredUser = userLoginRegisterService.registerUser(userData);

        System.out.println(" CheckIsNewUser :"+registeredUser.getUserId());
    }

}
