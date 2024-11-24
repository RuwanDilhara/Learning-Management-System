import { Component, Input } from '@angular/core';
import { Course } from '../../../../model/course';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-course-details',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './course-details.component.html',
  styleUrl: './course-details.component.css'
})
export class CourseDetailsComponent {

  @Input()
  public course:Course;
  constructor() {
    // Optionally initialize the course property
    this.course = {} as Course; // Initializing with an empty object of type Course
  }
  loardCourseInfo(str:Course){
    const tempcourse = new Course(str.courseId, str.courseTitle, str.description, str.courseFee, str.duration, str.teacherId, str.thumbnail, str.thumbnailPath, str.zoomLink, str.recordList);
    console.log(tempcourse.courseFee);
    
  }
  
}

