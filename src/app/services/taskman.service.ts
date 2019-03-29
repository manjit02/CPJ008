import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class TaskmanService {

  constructor(private http:HttpClient) { }

  getTasks() {
    return this.http.get('server/tasks');
  }

  getTask(id: number) {
    return this.http.get('server/task/' + id);
  }

  createTask(task) {
    let body = JSON.stringify(task);
    return this.http.post('server/addtask',body,httpOptions);
  }

  deleteTask(id: number) {
    return this.http.delete('server/deletetask');
  }

  updateTask(task) {
    let body = JSON.stringify(task);
    return this.http.put('server/updatetask',body,httpOptions);
  }
}
