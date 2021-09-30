package com.capstone.spring.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
public class Winners {
	
	    private int winnerId;
	    private String winnerName;
	    private String eventName;
	    private String prize;

	    @Id
	    @Column(name = "winnerId", nullable = false, insertable = true, updatable = true)
	    public int getwinnerId() {
	        return winnerId;
	    }

	    public void setwinnerId(int winnerId) {
	        this.winnerId = winnerId;
	    }

	    @Basic
	    @Column(name = "winnerName", nullable = false, insertable = true, updatable = true)
	    public String getwinnerName() {
	        return winnerName;
	    }

	    public void setwinnerName(String winnerName) {
	        this.winnerName = winnerName;
	    }

	    @Basic
	    @Column(name = "eventName", nullable = false, insertable = true, updatable = true, length = 30)
	    public String geteventName() {
	        return eventName;
	    }

	    public void seteventName(String eventName) {
	        this.eventName = eventName;
	    }

	    @Basic
	    @Column(name = "prize", nullable = false, insertable = true, updatable = true)
	    public String getprize() {
	        return prize;
	    }

	    public void setprize(String prize) {
	        this.prize = prize;
	    }

	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Winners winners = (Winners) o;

	        if (winnerId != winners.winnerId) return false;
	        if (prize != winners.prize) return false;
	        if (eventName != winners.eventName) return false;
	        if (winnerName != null ? !winnerName.equals(winners.winnerName) : winners.winnerName != null) return false;
	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = winnerId;
	        result = 31 * result + (winnerName != null ? winnerName.hashCode() : 0);
	        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
	        result = 31 * result + (prize != null ? prize.hashCode() : 0);
	        
	        return result;
	    }

}
