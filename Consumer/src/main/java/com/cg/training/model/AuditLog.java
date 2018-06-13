package com.cg.training.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AuditLog {

	/**
	 * 
	 */
	@Id
	private String eventId;

	/**
	 * 
	 */
	private String eventName;
	/**
	 * 
	 */
	private String eventType;
 
	/**
	 * 
	 */
	private Date eventDate;
	/**
	 * 
	 */
	private String userId;

	/**
	 * 
	 */
	private Object oldValue;

	/**
	 * 
	 */
	private Object newValue;

	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditLog(final String eventName, final String eventType,final String userId,final Object oldValue,final  Object newValue) {
		super();

		this.eventName = eventName;
		this.eventType = eventType;
		this.userId = userId;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public AuditLog(final String eventName,final String eventType,final String userId) {
		super();

		this.eventName = eventName;
		this.eventType = eventType;
		this.userId = userId;

	}

	
	@Override
	public String toString() {
		return "AuditLog [eventId=" + eventId + ", eventName=" + eventName + ", eventType=" + eventType + ", eventDate="
				+ eventDate + ", userId=" + userId + ", oldValue=" + oldValue + ", newValue=" + newValue + "]";
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(final UUID eventId) {
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(final String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(final String eventType) {
		this.eventType = eventType;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(final Date eventDate) {
		this.eventDate = new Date();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public Object getOldValue() {
		return oldValue;
	}

	public void setOldValue(final Object oldValue) {
		this.oldValue = oldValue;
	}

	public Object getNewValue() {
		return newValue;
	}

	public void setNewValue(final Object newValue) {
		this.newValue = newValue;
	}

}
