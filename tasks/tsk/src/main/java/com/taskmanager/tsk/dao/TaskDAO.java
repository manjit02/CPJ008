/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 27, 2018
 */

package com.taskmanager.tsk.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.tsk.entity.Tasks;

/**
 * @author n0136406
 *
 */
@Transactional
@Repository
public class TaskDAO implements ITaskDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.taskmanager.dao.ITaskDAO#getAllTasks()
	 */
	@SuppressWarnings("unchecked")
	public List<Tasks> getAllTasks() {
		String hql = "FROM Tasks as tsktb ORDER BY tsktb.taskId";
		return (List<Tasks>) entityManager.createQuery(hql).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.taskmanager.dao.ITaskDAO#getTasksById(int)
	 */
	public Tasks getTasksById(int taskId) {
		return entityManager.find(Tasks.class, taskId);
	}

	/* (non-Javadoc)
	 * @see com.taskmanager.dao.ITaskDAO#addTask(com.taskmanager.entity.Tasks)
	 */
	public void addTask(Tasks task) {
	    System.out.println("End date " + task.getEndDate());
	    System.out.println("Parent id " + task.getParentId());
	    System.out.println("Start date " + task.getStartDate());
	    System.out.println("task desk " + task.getTaskDesk());
	    System.out.println("Priority " + task.getPriority());
	    System.out.println("task id " + task.getTaskId());
	    if (task.getTaskId() >= 1) {
	        task = entityManager.merge(task);
	        }
	    
		entityManager.persist(task);

	}

	/* (non-Javadoc)
	 * @see com.taskmanager.dao.ITaskDAO#updateTask(com.taskmanager.entity.Tasks)
	 */
	public void updateTask(Tasks task) {
		Tasks taskU = getTasksById(task.getTaskId());
		taskU.setTaskDesk(task.getTaskDesk());
		taskU.setEndDate(task.getEndDate());
		taskU.setPriority(task.getPriority());
		entityManager.flush();

	}

	/* (non-Javadoc)
	 * @see com.taskmanager.dao.ITaskDAO#deleteTask(int)
	 */
	public void deleteTask(int taskId) {
		entityManager.remove(getTasksById(taskId));

	}

	/* (non-Javadoc)
	 * @see com.taskmanager.dao.ITaskDAO#TaskExists(java.lang.String)
	 */
	public boolean TaskExists(String taskDesk) {
		String hql = "FROM Tasks as atcl WHERE atcl.taskDesk = ?1";
		int count = entityManager.createQuery(hql).setParameter(1, taskDesk)
		              .getResultList().size();
		return count > 0 ? true : false;
	} 

}
