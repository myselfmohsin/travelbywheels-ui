package org.travelbywheels.jsf.common.beans;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.travelbywheels.jsf.common.data.UserData;
import org.travelbywheels.jsf.common.services.UserLoginRegisterService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by IntelliJ IDEA.
 * User: mohsin
 * Date: 24/11/2015
 * Time: 00:11
 * Copyright TravelByWheels.
 */
@ManagedBean
@SessionScoped
public class LoginRegisterBean {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(LoginRegisterBean.class);

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Boolean iAmNewUser;

    private String submitButtonValue;

    private String fullName;

    @ManagedProperty(value = "#{userLoginRegisterServiceImpl}")
    private UserLoginRegisterService userLoginRegisterService;

    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager;

    public LoginRegisterBean() {
        this.email = "";
        this.password = "";
        this.submitButtonValue = "Login Me";
        this.iAmNewUser = new Boolean(Boolean.FALSE);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getiAmNewUser() {
        return iAmNewUser;
    }

    public void setiAmNewUser(Boolean iAmNewUser) {
        this.iAmNewUser = iAmNewUser;
    }

    public String getSubmitButtonValue() {
        return submitButtonValue;
    }

    public void setSubmitButtonValue(String submitButtonValue) {
        this.submitButtonValue = submitButtonValue;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String login(){

        if (this.submitButtonValue.equals("Register Me")){
            LOG.info("=========> Create New User <=========");

            if(!userLoginRegisterService.checkIsNewUser(email)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email " + email + " already exist please login",""));
                LOG.info("User already exist message is set");
                return "incorrect";
            }
            UserData userData = new UserData();
            userLoginRegisterService.loadUserData(userData,this);
            userLoginRegisterService.registerUser(userData);

        }

        LOG.info("=========> Starting to login <=========");
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, password);
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            LOG.debug("Authenticated new user using authentication manager " + "Setting securityContext");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            userLoginRegisterService.loadLoginBean(this, this.email);
            if(this.submitButtonValue.equals("Register Me")){

                FacesContext.getCurrentInstance().addMessage("welcomeMsg", new FacesMessage("Successfully Registered", "<BR>Please follow the link in your email to activate this account."));
            } else {
                FacesContext.getCurrentInstance().addMessage("welcomeMsg", new FacesMessage("Welcome back ",this.fullName + "."));
            }
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "correct";
        } catch (final Exception e) {
            LOG.error("Error in login : " + e.getMessage());

//            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Invalid login", "Bad Credentials. Try again"));
        }

        return "incorrect";
    }

    public String logout(){

        SecurityContextHolder.clearContext();
        this.iAmNewUser = null;
        this.password = null;
        this.submitButtonValue = "Login Me";
        return "logout";
    }

    public void checkIsNewUser() {
        LOG.info("Checking is new user " + email + " " + this.iAmNewUser);
        if(this.email != null & this.iAmNewUser != null & this.iAmNewUser.booleanValue() == Boolean.TRUE){
            LOG.info("Register checkbox is set");
            if(!userLoginRegisterService.checkIsNewUser(email)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email " + email + " already exist please login",""));
                LOG.info("User already exist message is set");
            }
        }
        LOG.info("Setting Register Button");
        if (this.iAmNewUser != null & this.iAmNewUser.booleanValue() == Boolean.TRUE){
            this.submitButtonValue = "Register Me";
        } else {
            this.submitButtonValue = "Login Me";
        }
    }

    public UserLoginRegisterService getUserLoginRegisterService() {
        return userLoginRegisterService;
    }

    public void setUserLoginRegisterService(UserLoginRegisterService userLoginRegisterService) {
        this.userLoginRegisterService = userLoginRegisterService;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
