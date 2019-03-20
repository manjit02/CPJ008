/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 28, 2018
 */

package com.taskmanager.tsk.service;

import java.util.List;

import com.taskmanager.tsk.entity.Tasks;

/**
 * @author n0136406
 *
 */
public interface ITaskService {
    List<Tasks> getAllTasks();
    Tasks getTasksById(int taskId);
    boolean addTask(Tasks task);
    void updateTask(Tasks task);
    void deleteTask(int taskId);
}
