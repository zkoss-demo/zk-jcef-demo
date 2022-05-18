package org.zkoss.jcef.application.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserProfile {

	private String userName;
	private Date activationDate;
	private int coolPoints;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public int getCoolPoints() {
		return coolPoints;
	}
	public void setCoolPoints(int coolPoints) {
		this.coolPoints = coolPoints;
	}

	public UserProfile() {
		super();
	}
	
	public String getDisplayContent(){
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
		return String.format("Username: 1$, valid from $2. You have $3 cool points.", userName, dateFmt.format(activationDate), coolPoints);
	}
		
}
