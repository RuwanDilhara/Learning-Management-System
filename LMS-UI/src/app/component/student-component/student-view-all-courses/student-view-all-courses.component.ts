import { NgFor } from '@angular/common';
import { Component, OnInit} from '@angular/core';
import { CourseDetailsComponent } from '../course-details/course-details.component';
import { HttpClient } from '@angular/common/http';
import { Course } from '../../../../model/course';

@Component({
  selector: 'app-student-view-all-courses',
  standalone: true,
  imports: [NgFor,CourseDetailsComponent ],
  templateUrl: './student-view-all-courses.component.html',
  styleUrl: './student-view-all-courses.component.css'
})
export class StudentViewAllCoursesComponent{
  public courseList:Course[] = [];

  constructor(private http:HttpClient){
    this.loadCourses();
  }

  loadCourses(){
    this.http.get<Course[]>("http://localhost:8080/api/v1/course/all").subscribe(res=>{
      this.courseList = res;
    })
  }
  // ngOnInit(): void {
  //   this.loadCoursesInfo();
  // }
  
  
  
  
  
  // async loadCoursesInfo(){
  //   let responce =await fetch("http://localhost:8080/api/v1/course/all");
  //   let body =await responce.json();
  //   this.courseList = body;
  // }
}