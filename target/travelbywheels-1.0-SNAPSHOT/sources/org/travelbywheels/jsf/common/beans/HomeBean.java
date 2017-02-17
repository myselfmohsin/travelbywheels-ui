package org.travelbywheels.jsf.common.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.travelbywheels.jsf.common.services.MessageService;

import javax.faces.bean.ManagedBean;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 21/11/2015
 * Time: 01:58
 * Copyright TravelByWheels.
 */
@ManagedBean
public class HomeBean {

    @Qualifier("messageServiceImpl")
    @Autowired
    private MessageService messageService;

    public String getHelloMessage(){
        String msg;
        if(messageService != null)
            msg = messageService.getHelloMessage(new Date(Calendar.getInstance().getTime().getTime()));
        else
            msg = "Message Service is null";

        return msg;
    }
}
