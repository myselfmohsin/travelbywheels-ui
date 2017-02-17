package org.travelbywheels.jsf.common.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * UserData: mohsin
 * Date: 14/11/2015
 * Time: 00:49
 * Copyright TravelByWheels.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String isActiveFlag;
    private Timestamp createDate;
    private Long createdBy;
    private Timestamp lastUpdateDate;
    private Long lastUpdatedBy;

    private PersonData personDataByUserId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIsActiveFlag() {
        return isActiveFlag;
    }

    public void setIsActiveFlag(String isActiveFlag) {
        this.isActiveFlag = isActiveFlag;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public PersonData getPersonDataByUserId() {
        return personDataByUserId;
    }

    public void setPersonDataByUserId(PersonData personDataByUserId) {
        this.setUserId(personDataByUserId.getPersonId());
        this.personDataByUserId = personDataByUserId;
    }

}
