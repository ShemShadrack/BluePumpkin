package com.capstone.managedController;

import com.capstone.spring.model.Winners;
import com.capstone.spring.service.winnersService;

import org.springframework.dao.DataAccessException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ManagedBean(name = "wrnMB")
@ViewScoped
public class WinnersManagedController implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "ViewWinners";
    private static final String ERROR = "error";

    //Spring Customer Service is injected...
    @ManagedProperty(value = "#{WinnersService}")
    winnersService winnersService;

    @ManagedProperty("#{loginValidate}")
    private
    LoginValidate loginValidate;

    @ManagedProperty("#{actRequestMB}")
    private
    ActRegRequestController actRegRequestController;

    /**
     * Entity Parameters
     */
    private int winnerId;
    private String winnerName;
    private String eventName;
    private String prize;

    private Winners selectedAct;
    private List<Winners> selectedActs;

    /**
     * Requested
     */
    private List<Winners> WinnersList;
    private List<Winners> currentUserWinnersList;

    private Winners selectedWinners;
    private List<Winners> selectedActivities;
    private List<Winners> currentUserNotJoinedWinnersList;

    /**
     * Add Customer
     *
     * @return String - Response Message
     */
    public String addWinners() {
        try {
        	Winners winners = new Winners();
        	winners.setwinnerId(getWinnerId());
        	winners.setwinnerName(getWinnerName());
        	winners.seteventName(getEventName());
            winners.setprize(getPrize());

            getwinnersService().addWinners(winners);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    public void deleteWinners() {
        try {
        	Winners winners = new Winners();
        	winners = getwinnersService().getWinnersById(getWinnerId());
            getwinnersService().deleteWinners(winners);

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateWinners() {
        try {
            Winners winners = new Winners();
            winners.setwinnerId(getWinnerId());
        	winners.setwinnerName(getWinnerName());
        	winners.seteventName(getEventName());
            winners.setprize(getPrize());


            getwinnersService().updateWinners(winners);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reset Fields
     */
    public void reset() {

        this.setWinnerId(0);
        this.setWinnerName("");
        this.setEventName("");
        this.setPrize("");
    }

    /**
     * Get Winners List
     *
     * @return List - Winners List
     */
    public List<Winners> getWinnersList() {
        WinnersList = new ArrayList<Winners>();
        WinnersList.addAll(getwinnersService().getWinnerss());
        return WinnersList;
    }

    
    
    

    public List<Winners> getCurrentUserWinnersList() {
        currentUserWinnersList = new ArrayList<Winners>();

        for (Integer winnerId : actRegRequestController.getActRequestIdByUserId()) {
            currentUserWinnersList.add(getwinnersService().getWinnersById(winnerId));
        }

        return currentUserWinnersList;
    }

    public void setCurrentUserWinnersList(List<Winners> currentUserWinnersList) {
        this.currentUserWinnersList = currentUserWinnersList;
    }

    
    
    
    public List<Winners> getWinnersListByUserID() {
        WinnersList = new ArrayList<Winners>();
        WinnersList.addAll(getwinnersService().getWinnerss());
        return WinnersList;
    }

    public LoginValidate getLoginValidate() {
        return loginValidate;
    }

    public void setLoginValidate(LoginValidate loginValidate) {
        this.loginValidate = loginValidate;
    }

    public ActRegRequestController getActRegRequestController() {
        return actRegRequestController;
    }

    public void setActRegRequestController(ActRegRequestController actRegRequestController) {
        this.actRegRequestController = actRegRequestController;
    }

    public winnersService getwinnersService() {
        return winnersService;
    }

    public void setwinnersService(winnersService winnersService) {
        this.winnersService = winnersService;
    }

    public void setWinnersList(List<Winners> WinnersList) {
        this.WinnersList = WinnersList;
    }

    
    public int getWinnerId() {
        return winnerId;
    }

    /**
     * @param winnerId the winnerId to set
     */
    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    /**
     * @return the winnerName
     */
    public String getWinnerName() {
        return winnerName;
    }

    /**
     * @param winnerName the winnerName to set
     */
    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the prize
     */
    public String getPrize() {
        return prize;
    }

    /**
     * @param prize the prize to set
     */
    public void setPrize(String prize) {
        this.prize = prize;
    }

    
    
    public Winners getSelectedWinners() {
        return selectedWinners;
    }

    public void setSelectedWinners(Winners selectedWinners) {
        this.selectedWinners = selectedWinners;
    }

    public List<Winners> getCurrentUserNotJoinedWinnersList() {
        List<Winners> allActivitiesForClubUserJoined = getWinnersList();
        List<Winners> userJoinedActivities = getCurrentUserWinnersList();
        currentUserNotJoinedWinnersList = new ArrayList<Winners>();

        for (int i = 0; i < allActivitiesForClubUserJoined.size(); i++) {
            if (!userJoinedActivities.contains(allActivitiesForClubUserJoined.get(i))) {
                currentUserNotJoinedWinnersList.add(allActivitiesForClubUserJoined.get(i));
            }
        }
        return currentUserNotJoinedWinnersList;
    }

    public void setCurrentUserNotJoinedWinnersList(List<Winners> currentUserNotJoinedWinnersList) {
        this.currentUserNotJoinedWinnersList = currentUserNotJoinedWinnersList;
    }

    public List<Winners> getSelectedActivities() {
        return selectedActivities;
    }

    public void setSelectedActivities(List<Winners> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }

    /**
     * join selected clubs for the current user
     */
   

}
