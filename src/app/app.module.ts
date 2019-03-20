import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TaskmanService } from './services/taskman.service';
import { ViewtasksComponent } from './components/viewtasks/viewtasks.component';
import { HomeComponent } from './components/home/home.component';
import { EdittaskComponent } from './components/edittask/edittask.component';
import { FilterPipe } from './pipes/filter-pipe.pipe'

@NgModule({
  declarations: [
    AppComponent,
    ViewtasksComponent,
    HomeComponent,
    EdittaskComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [TaskmanService],
  bootstrap: [AppComponent]
})
export class AppModule { }
