/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Nov 28, 2018
 */

package com.taskmanager.tsk.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.taskmanager.tsk.entity.Tasks;

/**
 * @author n0136406
 *
 */
public class RestClientUtil {
	 public void getTaskByIdDemo() {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/task/{id}";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<Tasks> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Tasks.class, 1);
	        Tasks task = responseEntity.getBody();
	        System.out.println("Id:"+task.getTaskId()+", Title:"+task.getTaskDesk()
	                 +", Priority:"+task.getPriority());      
	    }
	    public void getAllTasksDemo() {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	            RestTemplate restTemplate = new RestTemplate();
	    	String url = "http://localhost:8080/user/tasks";
	            HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	            ResponseEntity<Tasks[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Tasks[].class);
	            Tasks[] taskss = responseEntity.getBody();
	            for(Tasks task : taskss) {
	                  System.out.println("Id:"+task.getTaskId()+", Title:"+task.getTaskDesk()
	                          +", Priority: "+task.getPriority());
	            }
	        }
	    public void addTaskDemo() {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/user/addtask";
	        Tasks objTask = new Tasks();
	//        objTask.setTaskId(1);
	        objTask.setParentId(1);
	        objTask.setTaskDesk("Spring REST Test");
	        objTask.setPriority(1);
	        objTask.setStartDate("01/01/2018");
	        HttpEntity<Tasks> requestEntity = new HttpEntity<Tasks>(objTask, headers);
	        URI uri = restTemplate.postForLocation(url, requestEntity);
	        System.out.println(uri.getPath());    	
	    }

}
