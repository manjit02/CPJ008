/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 28, 2018
 */

package com.taskmanager.tsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.taskmanager.tsk.entity.Tasks;
import com.taskmanager.tsk.service.ITaskService;

/**
 * @author n0136406
 *
 */
@RestController
/*@RequestMapping("user")*/
public class TaskController {

	@Autowired
	private ITaskService taskService;
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Tasks> getTaskById(@PathVariable("id") Integer id) {
		Tasks task = taskService.getTasksById(id);
		return new ResponseEntity<Tasks>(task, HttpStatus.OK);
	}
	       @GetMapping("/test")
	        public String getAllTests() {
	                System.out.println("Inside get tests");
	                
	                return "test";
	        }
	        
	@GetMapping("/tasks")
	public ResponseEntity<List<Tasks>> getAllTasks() {
		System.out.println("Inside get tasks");
		List<Tasks> tasks = taskService.getAllTasks();
		return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
	}
	@PostMapping("addtask")
	public ResponseEntity<Void> addTask(@RequestBody Tasks task, UriComponentsBuilder builder) {
        boolean flag = taskService.addTask(task);
        if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/task/{id}").buildAndExpand(task.getTaskId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("updatetask")
	public ResponseEntity<Tasks> updateTask(@RequestBody Tasks task) {
		taskService.updateTask(task);
		return new ResponseEntity<Tasks>(task, HttpStatus.OK);
	}
	@DeleteMapping("task/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id) {
		taskService.deleteTask(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
