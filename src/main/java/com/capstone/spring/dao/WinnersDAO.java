package com.capstone.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capstone.spring.model.Winners;


@Repository
public class WinnersDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set Hibernate Session Factory
     *
     * @param sessionFactory SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Add Winners
     *
     * @param   Winners Winners
     */

    public void addWinners(Winners Winners) {
        getSessionFactory().getCurrentSession().save(Winners);
    }

    /**
     * Delete Winners
     *
     * @param   Winners  Winners
     */

    public void deleteWinners(Winners Winners) {
        getSessionFactory().getCurrentSession().delete(Winners);
    }

    /**
     * Update Winners
     *
     * @param  Winners Winners
     */

    public void updateWinners(Winners Winners) {
        getSessionFactory().getCurrentSession().update(Winners);
    }

    /**
     * Get Winners
     *
     * @param  actId int
     * @return Winners
     */

    public Winners getWinnersById(int winnerId) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Winners  where winnerId=?")
                .setParameter(0, winnerId).list();
        return (Winners)list.get(0);
    }

    /**
     * Get Winners List
     *
     * @return List - customer list
     */

    public List<Winners> getWinnerss() {
        List list = getSessionFactory().getCurrentSession().createQuery("from  Winners").list();
        return list;
    }

}
