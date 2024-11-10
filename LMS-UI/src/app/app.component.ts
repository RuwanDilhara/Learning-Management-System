import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserProfileComponent } from "./components/user-profile/user-profile.component";
import { ScheduleComponent } from "./components/schedule/schedule.component";
import { AssignmentTrackingComponent } from "./components/assignment-tracking/assignment-tracking.component";
import { RemindersComponent } from "./components/reminders/reminders.component";
import { TimetableComponent } from "./components/timetable/timetable.component";
import { NotesComponent } from "./components/notes/notes.component";
import { GoalsComponent } from "./components/goals/goals.component";
import { AnalyticsComponent } from "./components/analytics/analytics.component";
import { SideBarComponent } from "./common/side-bar/side-bar.component";
import { HeaderComponent } from "./common/header/header.component";
import { FooterComponent } from "./common/footer/footer.component";
import { StudentDashboardComponent } from "./student-dashboard/student-dashboard.component";
import { AdminDashboardComponent } from "./admin-dashboard/admin-dashboard.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UserProfileComponent, AssignmentTrackingComponent, RemindersComponent, GoalsComponent, AnalyticsComponent, SideBarComponent, HeaderComponent, FooterComponent, StudentDashboardComponent, AdminDashboardComponent],
  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'RLP';
}
