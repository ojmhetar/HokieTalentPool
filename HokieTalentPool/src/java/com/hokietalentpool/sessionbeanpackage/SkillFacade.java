/*
 * Created by Ojas Mhetar on 2016.04.04  * 
 * Copyright © 2016 Ojas Mhetar. All rights reserved. * 
 */
package com.hokietalentpool.sessionbeanpackage;

import com.hokietalentpool.entitypackage.Skill;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ojmhetar
 */
@Stateless
public class SkillFacade extends AbstractFacade<Skill> {

    @PersistenceContext(unitName = "HokieTalentPoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SkillFacade() {
        super(Skill.class);
    }
    
    public List<Skill> findBySkill(String skill) {
        String query = "SELECT s FROM Skill s WHERE s.skillName = :skill";
        
        if (em.createQuery(query)
                .setParameter("skill", skill)
                .getResultList().isEmpty()) {
            return null;
        }
        else {
            return (List<Skill>) (em.createQuery(query)
                .setParameter("skill", skill)
                .getResultList());        
        }
    }
    
    public List<Skill> findByCategory(String category) {
        String query = "SELECT s FROM Skill s WHERE s.category = :category";
        
        if (em.createQuery(query)
                .setParameter("category", category)
                .getResultList().isEmpty()) {
            return null;
        }
        else {
            return (List<Skill>) (em.createQuery(query)
                .setParameter("category", category)
                .getResultList());        
        }
    }
    
}
