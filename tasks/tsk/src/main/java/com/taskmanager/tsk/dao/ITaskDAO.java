/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 27, 2018
 */

package com.taskmanager.tsk.dao;

import java.util.List;

import com.taskmanager.tsk.entity.Tasks;

/**
 * @author n0136406
 *
 */
public interface ITaskDAO{
    List<Tasks> getAllTasks();
    Tasks getTasksById(int taskId);
    void addTask(Tasks task);
    void updateTask(Tasks task);
    void deleteTask(int taskId);
    boolean TaskExists(String taskDesk);

}
