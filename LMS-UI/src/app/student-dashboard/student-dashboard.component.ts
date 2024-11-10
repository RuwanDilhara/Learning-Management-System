import { Component } from '@angular/core';
import { SideBarComponent } from '../common/side-bar/side-bar.component';
import { HeaderComponent } from '../common/header/header.component';
import { FooterComponent } from '../common/footer/footer.component';
import { RouterOutlet } from '@angular/router';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { CoursesComponent } from '../components/courses/courses.component';
import { AssignmentTrackingComponent } from '../components/assignment-tracking/assignment-tracking.component';
import { ViewGradeComponent } from '../components/view-grade/view-grade.component';
import { RemindersComponent } from '../components/reminders/reminders.component';
import { GoalsComponent } from '../components/goals/goals.component';
import { AnalyticsComponent } from '../components/analytics/analytics.component';

@Component({
  selector: 'app-student-dashboard',
  standalone: true,
  imports: [RouterOutlet,DashboardComponent,CoursesComponent,AssignmentTrackingComponent,ViewGradeComponent,RemindersComponent,GoalsComponent,AnalyticsComponent,SideBarComponent,FooterComponent,HeaderComponent],
  templateUrl: './student-dashboard.component.html',
  styleUrl: './student-dashboard.component.css'
})
export class StudentDashboardComponent {

}
