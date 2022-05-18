package org.zkoss.jcef.application.business;

import java.util.Date;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

public class MainViewModel {

	private UserProfile currentProfile;
	
	private int selectedTabIndex;
	private int resetSelection = -1;
	
	@Init
	public void init() {
		selectedTabIndex = 0;
		
		currentProfile = new UserProfile();
		currentProfile.setUserName("Anonymous");
		currentProfile.setActivationDate(new Date());
		currentProfile.setCoolPoints(50);
	}

	public UserProfile getCurrentProfile() {
		return currentProfile;
	}

	public void setCurrentProfile(UserProfile currentProfile) {
		this.currentProfile = currentProfile;
	}
	
	public int getSelectedTabIndex() {
		return selectedTabIndex;
	}
	
	public int getResetSelection() {
		return resetSelection;
	}

	public void setSelectedTabIndex(int selectedTabIndex) {
		this.selectedTabIndex = selectedTabIndex;
	}

	@Command
	public void navigateToIndex(@BindingParam int index) {
		selectedTabIndex = index;
		BindUtils.postNotifyChange(this, "selectedTabIndex", "resetSelection");
	}
	

}
