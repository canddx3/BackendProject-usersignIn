package com.volapp.events;

/*import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
@Table(name="events")
public class Events{


    private String eventName;
    private String eventLocation;
    private String eventDate;
    private String eventTime;
    private String eventDescription;
    private String charityName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    public Events() {}
    
    public Events(Events events) {
    	this.id = events.id;
    	this.charityName = events.charityName;
    	this.eventName = events.eventName;
    	this.eventLocation = events.eventLocation;
    	this.eventDate = events.eventDate;
    	this.eventTime = events.eventTime;
    	this.eventDescription = events.eventDescription;
    }
    
    public Events (Long id, String charityName, String eventName, String eventLocation, String eventDate, String eventTime, String eventDescription) {
    	this.id = id;
    	this.charityName = charityName;
    	this.eventName = eventName;
    	this.eventLocation = eventLocation;
    	this.eventDate = eventDate;
    	this.eventTime = eventTime;
    	this.eventDescription = eventDescription;
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCharityName() {
		return charityName;
	}
	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
    
}
