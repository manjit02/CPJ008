/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 28, 2018
 */

package com.taskmanager.tsk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.tsk.dao.ITaskDAO;
import com.taskmanager.tsk.entity.Tasks;

/**
 * @author n0136406
 *
 */
@Service
public class TaskService implements ITaskService {

	/* (non-Javadoc)
	 * @see com.taskmanager.service.ITaskService#getAllTaks()
	 */
	@Autowired
	private ITaskDAO taskDAO;
	
	@Override
	public List<Tasks> getAllTasks() {
		return taskDAO.getAllTasks();
	}

	/* (non-Javadoc)
	 * @see com.taskmanager.service.ITaskService#getTasksById(int)
	 */
	@Override
	public Tasks getTasksById(int taskId) {
		Tasks obj = taskDAO.getTasksById(taskId);
		return obj;
	}

	/* (non-Javadoc)
	 * @see com.taskmanager.service.ITaskService#addTask(com.taskmanager.entity.Tasks)
	 */
	@Override
	public boolean addTask(Tasks task) {
        if (taskDAO.TaskExists(task.getTaskDesk())) {
            return false;
        } else {
            taskDAO.addTask(task);
            return true;
        }
	}

	/* (non-Javadoc)
	 * @see com.taskmanager.service.ITaskService#updateArticle(com.taskmanager.entity.Tasks)
	 */
	@Override
	public void updateTask(Tasks task) {
		taskDAO.updateTask(task);
	}

	/* (non-Javadoc)
	 * @see com.taskmanager.service.ITaskService#deleteArticle(int)
	 */
	@Override
	public void deleteTask(int taskId) {
		taskDAO.deleteTask(taskId);

	}

}
