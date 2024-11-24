import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-read-more-course',
  standalone: true,
  imports: [],
  templateUrl: './read-more-course.component.html',
  styleUrl: './read-more-course.component.css'
})
export class ReadMoreCourseComponent {
  @Input()
  public readmore:any;
}
