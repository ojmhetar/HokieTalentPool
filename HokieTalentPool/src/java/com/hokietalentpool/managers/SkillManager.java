/*
 * Created by Ojas Mhetar on 2016.05.19  * 
 * Copyright © 2016 Ojas Mhetar. All rights reserved. * 
 */
package com.hokietalentpool.managers;

import com.hokietalentpool.entitypackage.Skill;
import com.hokietalentpool.sessionbeanpackage.SkillFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "skillManager")
@SessionScoped
/**
 *
 * @author ojmhetar
 */
public class SkillManager implements Serializable {
    
    private String query; 
    private String queryCategory; 
    private List<Skill> results; 
    
    
    @EJB
    private SkillFacade skillFacade;
    
    
    public SkillManager() {
        
    }
    
    public String searchSkills() { 
        results = skillFacade.findBySkill(query);
        return "";
    }
    
    public String searchCategory() { 
        results = skillFacade.findByCategory(queryCategory);
        return "";
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public String getQuery() {
        return query;
    }
    
    public void setQueryCategory(String query) {
        this.queryCategory = query;
    }
    
    public String getQueryCategory() {
        return queryCategory;
    }
    
    public List<Skill> getResults(){
        return results;
    }
    
    public void setResults(List<Skill> results) {
        this.results = results; 
    }
    
}
