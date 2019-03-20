import { Component, OnInit } from '@angular/core';
import { TaskmanService } from '../../services/taskman.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable'


@Component({
  selector: 'app-edittask',
  templateUrl: './edittask.component.html',
  styleUrls: ['./edittask.component.css']
})
export class EdittaskComponent implements OnInit {

  taskeform: FormGroup;
  validMessage: string = "";

  public taskEd;
  constructor( private taskService: TaskmanService, private route: ActivatedRoute) { }

  ngOnInit() {

    this.taskeform = new FormGroup({
      taskId: new FormControl('',Validators.required),
      priority: new FormControl('',Validators.required),
      parentId: new FormControl('',Validators.required),
      startDate: new FormControl('',Validators.required),
      taskDesk:  new FormControl('',Validators.required),
      endDate: new FormControl()
    });

      this.getTaskEd(this.route.snapshot.params.id);
      //this.populateForm();
  }

  getTaskEd(id: number) {
      var _that = this;
    this.taskService.getTask(id).subscribe(
        data => {
         // console.log(data);
          _that.taskEd = data
            this.populateForm()
        },
        err => console.error(err),
        () => console.log('task loaded')
    );

  }

    populateForm() {
        //console.log(JSON.stringify(this.taskEd));
        this.taskeform.controls['taskId'].setValue(this.taskEd.taskId);
        this.taskeform.controls['parentId'].setValue(this.taskEd.parentId);
        this.taskeform.controls['priority'].setValue(this.taskEd.priority);
        this.taskeform.controls['startDate'].setValue(this.taskEd.startDate);
        this.taskeform.controls['taskDesk'].setValue(this.taskEd.taskDesk);
        this.taskeform.controls['endDate'].setValue(this.taskEd.endDate);
    }


  editTask() {
    if (this.taskeform.valid) {
      this.validMessage = "Task has been updated successfully";
      this.taskService.updateTask(this.taskeform.value).subscribe(
              data => {
            this.taskeform.reset()
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

}
