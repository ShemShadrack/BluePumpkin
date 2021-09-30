package com.capstone.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capstone.spring.model.ClubNews;

import java.util.List;


@Repository
public class ClubNewsDAO {

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


    public void addClubNews(ClubNews clubNews) {
        getSessionFactory().getCurrentSession().save(clubNews);
    }


    public void deleteClubNews(ClubNews clubNews) {
        getSessionFactory().getCurrentSession().delete(clubNews);
    }

    public void updateClubNews(ClubNews clubNews) {
        getSessionFactory().getCurrentSession().update(clubNews);
    }

    public ClubNews getClubNewsById(int newsId) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from  ClubNews where newsId=?")
                .setParameter(0, newsId).list();
        return (ClubNews)list.get(0);
    }

    public List<ClubNews> getClubNewsList() {
        List list = getSessionFactory().getCurrentSession().createQuery("from  ClubNews").list();
        return list;
    }
    
    public List<ClubNews> getClubNewssByUserIdClubId(int userId, int clubId){
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from ClubNews where userId=? and clubId=?")
                .setParameter(0, userId)
                .setParameter(1, clubId)
                .list();
        return list;
    }
}
