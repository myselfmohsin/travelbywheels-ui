package org.travelbywheels.jsf.common.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 19/11/2015
 * Time: 02:01
 * Copyright TravelByWheels.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class TestMessageService {


    @Qualifier("messageServiceImpl")
    @Autowired
    private MessageService messageService;

    @Test
    public void testGetMessage(){

        System.out.println(messageService.getHelloMessage(new Date(Calendar.getInstance().getTime().getTime())));
    }

}
