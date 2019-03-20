import { Component, OnInit } from '@angular/core';
import { TaskmanService } from '../../services/taskman.service';
import { FilterPipe } from '../../pipes/filter-pipe.pipe';

@Component({
  selector: 'app-viewtasks',
  templateUrl: './viewtasks.component.html',
  styleUrls: ['./viewtasks.component.css']
})
export class ViewtasksComponent implements OnInit {

  public tasklist;

  constructor(private taskService: TaskmanService) { }

  ngOnInit() {
    this.getAllTasks();
  }

  getAllTasks() {
    this.taskService.getTasks().subscribe(
      data => { this.tasklist = data},
      err => console.error(err),
      () => console.log('tasks loaded')
    );
  }

}
