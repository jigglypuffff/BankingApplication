package com.cg.training.model;

import java.io.Serializable;
import java.util.Date;

public class AuditLog implements Serializable {

	private String eventId;

	private String eventName;
	private String eventType;

	private Date eventDate;
	private String userId;

	private Object oldValue;

	private Object newValue;

	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditLog(String eventName, String eventType, String userId, Object oldValue, Object newValue) {
		super();

		this.eventName = eventName;
		this.eventType = eventType;
		this.userId = userId;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	@Override
	public String toString() {
		return "AuditLog [eventId=" + eventId + ", eventName=" + eventName + ", eventType=" + eventType + ", eventDate="
				+ eventDate + ", userId=" + userId + ", oldValue=" + oldValue + ", newValue=" + newValue + "]";
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = new Date();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Object getOldValue() {
		return oldValue;
	}

	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}

	public Object getNewValue() {
		return newValue;
	}

	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

}
