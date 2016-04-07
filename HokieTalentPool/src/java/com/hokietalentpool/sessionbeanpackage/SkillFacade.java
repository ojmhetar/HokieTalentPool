/*
 * Created by Ojas Mhetar on 2016.04.04  * 
 * Copyright © 2016 Ojas Mhetar. All rights reserved. * 
 */
package com.hokietalentpool.sessionbeanpackage;

import com.hokietalentpool.entitypackage.Skill;
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
    
}
