package org.wso2.carbon.apimgt.tutorial.trainschedule;

public class ScheduleEntry {
	private String entryId;
	private String startTime;
	private String endTime;
	private String from;
	private String to;
	private String trainId;
	private String facilities;
	private String imageURL;

	public ScheduleEntry(String entryId, String startTime, String endTime, String from, String to, String trainId) {
		this.entryId = entryId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.from = from;
		this.to = to;
		this.trainId = trainId;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTrainId() {
		return this.trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getEntryId() {
		return this.entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
