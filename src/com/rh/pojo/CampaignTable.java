package com.rh.pojo;

import java.util.Date;

public class CampaignTable {

	private long Campaign_Id;
	private String App_Name;
	private String Playstore_Link;
	private String Developer_email;
	private String App_Image;
	private String Status;
	private long RegID;
	private Date creation_time;
	private Date last_update_time;
	public long getCampaign_Id() {
		return Campaign_Id;
	}
	public void setCampaign_Id(long campaign_Id) {
		Campaign_Id = campaign_Id;
	}
	public String getApp_Name() {
		return App_Name;
	}
	public void setApp_Name(String app_Name) {
		App_Name = app_Name;
	}
	public String getPlaystore_Link() {
		return Playstore_Link;
	}
	public void setPlaystore_Link(String playstore_Link) {
		Playstore_Link = playstore_Link;
	}
	public String getDeveloper_email() {
		return Developer_email;
	}
	public void setDeveloper_email(String developer_email) {
		Developer_email = developer_email;
	}
	public String getApp_Image() {
		return App_Image;
	}
	public void setApp_Image(String app_Image) {
		App_Image = app_Image;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public long getRegID() {
		return RegID;
	}
	public void setRegID(long regID) {
		RegID = regID;
	}
	public Date getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public Date getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}
	
	
}
