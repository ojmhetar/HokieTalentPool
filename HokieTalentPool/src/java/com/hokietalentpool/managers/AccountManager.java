/*
 * Created by Ojas Mhetar on 2016.02.27  * 
 * Copyright © 2016 Ojas Mhetar. All rights reserved. * 
 */
package com.hokietalentpool.managers;

import com.hokietalentpool.entitypackage.Skill;
import com.hokietalentpool.entitypackage.User;
import com.hokietalentpool.sessionbeanpackage.SkillFacade;
import com.hokietalentpool.sessionbeanpackage.UserFacade;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
 
@Named(value = "accountManager")
@SessionScoped
/**
 *
 * @author Mhetar
 */
public class AccountManager implements Serializable {
 
    // Instance Variables (Properties)
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String statusMessage;
    private int security_question;
    private String security_answer;
    private int schoolYear; 
    private String major;
    private String category1;
    private String skill1; 
    private String category2;
    private String skill2; 
    private String category3;
    private String skill3; 
    private String category4;
    private String skill4; 
    private String category5;
    private String skill5; 
    
    private Map<String, Object> security_questions;
    private Map<String, Object> categories; 
    private Map<String, Object> school_years;
    
    private User selected;
    
    /**
     * The instance variable 'userFacade' is annotated with the @EJB annotation.
     * This means that the GlassFish application server, at runtime, will inject in
     * this instance variable a reference to the @Stateless session bean UserFacade.
     */
    @EJB
    private UserFacade userFacade;
    
    @EJB
    private SkillFacade skillFacade;

    /**
     * The instance variable 'photoFacade' is annotated with the @EJB annotation.
     * This means that the GlassFish application server, at runtime, will inject in
     * this instance variable a reference to the @Stateless session bean PhotoFacade.
     */
//    @EJB
//    private PhotoFacade photoFacade;

  


    /**
     * Creates a new instance of AccountManager
     */
    public AccountManager() {
    }

    /**
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    
    public void setCategory1(String category) {
        this.category1 = category;
    }

    public String getCategory1() {
        return category1;
    }
    
    public void setCategory2(String category) {
        this.category2 = category;
    }

    public String getCategory2() {
        return category2;
    }
    
    public void setCategory3(String category) {
        this.category3 = category;
    }

    public String getCategory3() {
        return category3;
    }
    
    public void setCategory4(String category) {
        this.category4 = category;
    }

    public String getCategory4() {
        return category4;
    }
    
    public void setCategory5(String category) {
        this.category5 = category;
    }

    public String getCategory5() {
        return category5;
    }
    
    public String getSkill1() { 
        return skill1; 
    }
    
    public void setSkill1(String skill) {
        this.skill1 = skill; 
    }
    
    public String getSkill2() { 
        return skill2; 
    }
    
    public void setSkill2(String skill) {
        this.skill2 = skill; 
    }
    
    public String getSkill3() { 
        return skill3; 
    }
    
    public void setSkill3(String skill) {
        this.skill3 = skill; 
    }
    
    public String getSkill4() { 
        return skill4; 
    }
    
    public void setSkill4(String skill) {
        this.skill4 = skill; 
    }
    
    public String getSkill5() { 
        return skill1; 
    }
    
    public void setSkill5(String skill) {
        this.skill5 = skill; 
    }
    
    public void setMajor(String major) {
        this.major = major; 
    }
    
    public String getMajor() {
        return major; 
    }
    
    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear; 
    }
    
    public int getSchoolYear(){
        return schoolYear; 
    }
    
    public int getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(int security_question) {
        this.security_question = security_question;
    }

    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

    public Map<String, Object> getSecurity_questions() {
        if (security_questions == null) {
            security_questions = new LinkedHashMap<>();
            for (int i = 0; i < Constants.QUESTIONS.length; i++) {
                security_questions.put(Constants.QUESTIONS[i], i);
            }
        }
        return security_questions;
    }
    
    public Map<String, Object> getCategories() {
        if (categories == null) {
            categories = new LinkedHashMap<>();
            for (int i = 0; i < Constants.CATEGORIES.length; i++) {
                categories.put(Constants.CATEGORIES[i], i);
            }
        }
        return categories;
    }
    
    public Map<String, Object> getSchool_years() {
        if (school_years == null) {
            school_years = new LinkedHashMap<>();
            for (int i = 0; i < Constants.SCHOOL_YEARS.length; i++) {
                school_years.put(Constants.SCHOOL_YEARS[i], i);
            }
        }
        return school_years;
    }
    
    
    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage the statusMessage to set
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public User getSelected() {
        if (selected == null) {
            selected = userFacade.find(FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("user_id"));
        }
        return selected;
    }

    public void setSelected(User selected) {
        this.selected = selected;
    }

    public String createAccount() {
        
        // Check to see if a user already exists with the username given.
        User aUser = userFacade.findByUsername(username);
        
        if (aUser != null) {
            username = "";
            statusMessage = "Username already exists! Please select a different one!";
            return "";
        }

        if (statusMessage.isEmpty()) {
            try {
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);                
                user.setSecurityQuestion(1);
                user.setSecurityAnswer("Test");
                user.setEmail(email);  
                user.setUsername(username);
                user.setPassword(password);
                user.setSchoolYear(2);
                user.setMajor("Test");
                user.setCategory1(category1);
                user.setCategory2(category2);
                user.setCategory3(category3);
                user.setCategory4(category4);
                user.setCategory5(category5);
                user.setSkill1(skill1);
                user.setSkill2(skill2);
                user.setSkill3(skill3);
                user.setSkill4(skill4);
                user.setSkill5(skill5);
                       
             
                userFacade.create(user);                
            } catch (EJBException e) {
                username = "";
                statusMessage = "Something went wrong while creating your account!";
                return "";
            }
            initializeSessionMap();
            User skillUser = userFacade.findByUsername(username);
            int auto = 0; 
            try {
                Skill skillEntry1 = new Skill(auto, category1, skill1);
                skillEntry1.setUserId(skillUser);
                Skill skillEntry2 = new Skill(auto, category2, skill2);
                skillEntry2.setUserId(skillUser);
                Skill skillEntry3 = new Skill(auto, category3, skill3);
                skillEntry3.setUserId(skillUser);
                Skill skillEntry4 = new Skill(auto, category4, skill4);
                skillEntry4.setUserId(skillUser);
                Skill skillEntry5 = new Skill(auto, category5, skill5);
                skillEntry5.setUserId(skillUser);
                
                skillFacade.create(skillEntry1);
                skillFacade.create(skillEntry2);
                skillFacade.create(skillEntry3);
                skillFacade.create(skillEntry4);
                skillFacade.create(skillEntry5);
                
            } catch (EJBException e) {
                statusMessage = "Problem with skills.";
                return ""; 
            }
            return "Profile";
        }
        return "";
    }

    public String updateAccount() {
        if (statusMessage.isEmpty()) {
            int user_id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user_id");
                User editUser = userFacade.getUser(user_id);
            try {
                editUser.setFirstName(this.selected.getFirstName());
                editUser.setLastName(this.selected.getLastName());             
                editUser.setEmail(this.selected.getEmail());
                editUser.setPassword(this.selected.getPassword());
                userFacade.edit(editUser);
            } catch (EJBException e) {
                username = "";
                statusMessage = "Something went wrong while editing your profile!";
                return "";
            }
            return "Profile";
        }
        return "";
    }
    
    public String deleteAccount() {
        if (statusMessage.isEmpty()) {
            int user_id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user_id");
            try {
                userFacade.deleteUser(user_id);
                                
            } catch (EJBException e) {
                username = "";
                statusMessage = "Something went wrong while deleting your account!";
                return "";
            }
            
            return "/index.xhtml?faces-redirect=true";
        }
        return "";
    }
    
    public void validateInformation(ComponentSystemEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();

        UIComponent components = event.getComponent();
        // Get password
        UIInput uiInputPassword = (UIInput) components.findComponent("password");
        String pwd = uiInputPassword.getLocalValue() == null ? ""
                : uiInputPassword.getLocalValue().toString();

        // Get confirm password
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmPassword");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();

        if (pwd.isEmpty() || confirmPassword.isEmpty()) {
            // Do not take any action. 
            // The required="true" in the XHTML file will catch this and produce an error message.
            return;
        }

        if (!pwd.equals(confirmPassword)) {
            statusMessage = "Passwords must match!";
        } else {
            statusMessage = "";
        }   
    }

    public void initializeSessionMap() {
        User user = userFacade.findByUsername(getUsername());
        FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().put("username", username);
        FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().put("user_id", user.getId());
    }

    private boolean correctPasswordEntered(UIComponent components) {
        UIInput uiInputVerifyPassword = (UIInput) components.findComponent("verifyPassword");
        String verifyPassword = uiInputVerifyPassword.getLocalValue() == null ? ""
                : uiInputVerifyPassword.getLocalValue().toString();
        if (verifyPassword.isEmpty()) {
            statusMessage = "";
            return false;
        } else {
            if (verifyPassword.equals(password)) {
                return true;
            } else {
                statusMessage = "Invalid password entered!";
                return false;
            }
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        username = firstName = lastName = password = email = statusMessage = "";
        security_answer  =  "";
        security_question = 0;
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
   


}