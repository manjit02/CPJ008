/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 27, 2018
 */

package com.taskmanager.tsk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author n0136406
 *
 */
@Entity
@Table(name="task_table")
public class Tasks implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TaskId")
        private int taskId;  
	@Column(name="ParentId")
        private int parentId;
	@Column(name="TaskDesk")	
	private String taskDesk;
	@Column(name="StartDate")	
	private String startDate;
	@Column(name="EndDate")	
	private String endDate;
	@Column(name="Priority")	
	private int priority;
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTaskDesk() {
		return taskDesk;
	}
	
	public void setTaskDesk(String taskDesk) {
		this.taskDesk = taskDesk;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}	
}
