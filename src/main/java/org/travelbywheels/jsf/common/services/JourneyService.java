package org.travelbywheels.jsf.common.services;

import org.travelbywheels.jsf.common.data.JourneyData;
import org.travelbywheels.jsf.travellers.beans.PlanJourneyBean;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 02/12/2015
 * Time: 17:59
 * Copyright TravelByWheels.
 */
public interface JourneyService {

    public JourneyData postJourney(PlanJourneyBean planJourneyBean);

}
