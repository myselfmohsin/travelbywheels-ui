package org.travelbywheels.jsf.travellers.beans;

import org.springframework.security.access.prepost.PreAuthorize;
import org.travelbywheels.jsf.common.beans.LoginRegisterBean;
import org.travelbywheels.jsf.common.services.JourneyService;
import org.travelbywheels.jsf.common.services.UserLoginRegisterService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 01/12/2015
 * Time: 17:00
 * Copyright TravelByWheels.
 */
@ManagedBean
@SessionScoped
public class PlanJourneyBean {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PlanJourneyBean.class);

    private Long fromCityCode;

    private String fromCityName;

    private Long toCityCode;

    private String toCityName;

    private Date departureDateTime;

    private Date returnDateTime;

    private Long noOfPassengers;

    private String isAcNonAcNeeded;

    private Boolean isLuggageCarrierNeeded;

    private Boolean isSoundSystemNeeded;

    private String specialRequest;

    @ManagedProperty(value = "#{journeyServiceImpl}")
    private JourneyService journeyService;

    public PlanJourneyBean() {

        this.fromCityName = "Pune";
        this.toCityName = "Mumbai";
    }

    public Long getFromCityCode() {
        return fromCityCode;
    }

    public void setFromCityCode(Long fromCityCode) {
        this.fromCityCode = fromCityCode;
    }

    public String getFromCityName() {
        return fromCityName;
    }

    public void setFromCityName(String fromCityName) {
        this.fromCityName = fromCityName;
    }

    public Long getToCityCode() {
        return toCityCode;
    }

    public void setToCityCode(Long toCityCode) {
        this.toCityCode = toCityCode;
    }

    public String getToCityName() {
        return toCityName;
    }

    public void setToCityName(String toCityName) {
        this.toCityName = toCityName;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public Long getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Long noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getIsAcNonAcNeeded() {
        return isAcNonAcNeeded;
    }

    public void setIsAcNonAcNeeded(String isAcNonAcNeeded) {
        this.isAcNonAcNeeded = isAcNonAcNeeded;
    }

    public Boolean getIsLuggageCarrierNeeded() {
        return isLuggageCarrierNeeded;
    }

    public void setIsLuggageCarrierNeeded(Boolean isLuggageCarrierNeeded) {
        this.isLuggageCarrierNeeded = isLuggageCarrierNeeded;
    }

    public Boolean getIsSoundSystemNeeded() {
        return isSoundSystemNeeded;
    }

    public void setIsSoundSystemNeeded(Boolean isSoundSystemNeeded) {
        this.isSoundSystemNeeded = isSoundSystemNeeded;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public JourneyService getJourneyService() {
        return journeyService;
    }

    public void setJourneyService(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    public String postJourney(){

        try{
            journeyService.postJourney(this);
        } catch (Exception e){

        }


        LOG.info("Secure Posting Journey : From City : "+ this.fromCityName+" To City : "+this.toCityName+". For user : ");


        return "home";
    }
}
