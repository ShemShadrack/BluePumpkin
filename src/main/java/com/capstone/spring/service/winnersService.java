package com.capstone.spring.service;

import java.util.List;

import com.capstone.spring.dao.WinnersDAO;
import com.capstone.spring.model.Winners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("WinnersService")
@Transactional(readOnly = true)
public class winnersService {
	
	 // WinnersDAO is injected...
    @Autowired
    WinnersDAO WinnersDAO;

    /**
     * Add Winners
     *
     * @param  Winners Winners
     */
    @Transactional(readOnly = false)
    public void addWinners(Winners Winners) {
        getWinnersDAO().addWinners(Winners);
    }

    /**
     * Delete Winners
     *
     * @param   Winners  Winners
     */
    @Transactional(readOnly = false)
    public void deleteWinners(Winners Winners) {
        getWinnersDAO().deleteWinners(Winners);
    }

    /**
     * Update Winners
     *
     * @param Winners  Winners
     */
    @Transactional(readOnly = false)
    public void updateWinners(Winners Winners) {
        getWinnersDAO().updateWinners(Winners);
    }

    /**
     * Get Winners
     *
     * @param  id int Winners Id
     */

    public Winners getWinnersById(int id) {
        return getWinnersDAO().getWinnersById(id);
    }

    /**
     * Get Winners List
     *
     */

    public List<Winners> getWinnerss() {
        return getWinnersDAO().getWinnerss();
    }

    /**
     * Get Winners DAO
     *
     * @return WinnersDAO - Winners DAO
     */
    public WinnersDAO getWinnersDAO() {
        return WinnersDAO;
    }

    /**
     * Set Winners DAO
     *
     * @param  WinnersDAO - WinnersDAO
     */
    public void setWinnersDAO(WinnersDAO WinnersDAO) {
        this.WinnersDAO = WinnersDAO;
    }

}
