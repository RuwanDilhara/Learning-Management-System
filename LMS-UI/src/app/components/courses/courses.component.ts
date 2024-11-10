import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CourseComponent } from "../course/course.component";

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [NgFor, CourseComponent],
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.css'
})
export class CoursesComponent implements OnInit{
  ngOnInit(): void {
    this.loadCourses();
  }

  public coursesList:any = [];

  async loadCourses(){

    let response = await fetch("https://fakestoreapi.com/products");
    let bode = await response.json();
    this.coursesList = bode;
     

  }

}
