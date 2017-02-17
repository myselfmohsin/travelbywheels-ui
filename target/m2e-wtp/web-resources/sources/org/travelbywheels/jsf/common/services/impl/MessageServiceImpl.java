package org.travelbywheels.jsf.common.services.impl;

import org.springframework.stereotype.Service;
import org.travelbywheels.jsf.common.services.MessageService;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 07/11/2015
 * Time: 01:53
 * Copyright TravelByWheels.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public String getHelloMessage(Date date) {
        return "Hello World! "+date.toString();
    }
}
