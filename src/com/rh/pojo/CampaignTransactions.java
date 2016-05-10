package com.rh.pojo;

import java.util.Date;

public class CampaignTransactions {
	
	private long Campaign_Id;
	private long OfferPkgId;
	private long InstallLimit;
	private long Conversion;
	private String Campaign_Status;
	private String remarks;
	private Date creation_time;
	private Date last_update_time;
	private long RegID;
	public long getCampaign_Id() {
		return Campaign_Id;
	}
	public void setCampaign_Id(long campaign_Id) {
		Campaign_Id = campaign_Id;
	}
	public long getOfferPkgId() {
		return OfferPkgId;
	}
	public void setOfferPkgId(long offerPkgId) {
		OfferPkgId = offerPkgId;
	}
	public long getInstallLimit() {
		return InstallLimit;
	}
	public void setInstallLimit(long installLimit) {
		InstallLimit = installLimit;
	}
	public long getConversion() {
		return Conversion;
	}
	public void setConversion(long conversion) {
		Conversion = conversion;
	}
	public String getCampaign_Status() {
		return Campaign_Status;
	}
	public void setCampaign_Status(String campaign_Status) {
		Campaign_Status = campaign_Status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public long getRegID() {
		return RegID;
	}
	public void setRegID(long regID) {
		RegID = regID;
	}
	
	
	

}
