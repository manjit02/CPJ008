import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewtasksComponent } from './components/viewtasks/viewtasks.component';
import { HomeComponent } from './components/home/home.component';
import { EdittaskComponent } from './components/edittask/edittask.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent

  },

  {
    path: 'edittask/:id',
    component: EdittaskComponent
  },

  {
    path: 'viewtasks',
    component: ViewtasksComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
