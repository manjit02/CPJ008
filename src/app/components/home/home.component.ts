import { Component, OnInit } from '@angular/core';
import { TaskmanService } from '../../services/taskman.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  taskform: FormGroup;
  validMessage: string = "";

  constructor( private taskmanService: TaskmanService ) { }

  ngOnInit() {
    this.taskform = new FormGroup({
      taskId: new FormControl('',Validators.required),
      priority: new FormControl('',Validators.required),
      parentId: new FormControl('',Validators.required),
      startDate: new FormControl('',Validators.required),
      taskDesk:  new FormControl('',Validators.required),
      endDate: new FormControl()
    });
  }

  submitTask() {
    if (this.taskform.valid) {
      this.validMessage = "Task has been added successfully";
      this.taskmanService.createTask(this.taskform.value).subscribe(
          data => {
            this.taskform.reset()
            return true;
          },
            error => {
              return Observable.throw(error);
            }
      )
    } else {
      this.validMessage = "Please fill out the form before submitting";
    }
  }

  resetForm() {
    this.taskform.reset();
  }
}
