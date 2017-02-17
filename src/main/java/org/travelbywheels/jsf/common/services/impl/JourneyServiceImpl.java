package org.travelbywheels.jsf.common.services.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.travelbywheels.jsf.common.data.JourneyData;
import org.travelbywheels.jsf.common.services.JourneyService;
import org.travelbywheels.jsf.travellers.beans.PlanJourneyBean;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 02/12/2015
 * Time: 18:02
 * Copyright TravelByWheels.
 */

@Service
public class JourneyServiceImpl implements JourneyService {

    @PreAuthorize("hasRole('Traveller')")
    @Override
    public JourneyData postJourney(PlanJourneyBean planJourneyBean) {
        return null;
    }
}
