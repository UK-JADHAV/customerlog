package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class LogModel
{   
	@Id
	@Column(name="id")
	private String Id;
	
	
	@Column(name="name")
	@JsonIgnore
	private String name;
	
	@Column(name="logType")
	private String logType;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
    private String time;
	
	@Override
	public String toString() {
		return "LogModel [Id=" + Id + ", logType=" + logType + ", date=" + date + ", time=" + time
				+ "]";
	}

	public LogModel()
	{
		
	}
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
	
}
