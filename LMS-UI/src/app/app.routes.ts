import { Routes } from '@angular/router';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { ScheduleComponent } from './components/schedule/schedule.component';
import { AssignmentTrackingComponent } from './components/assignment-tracking/assignment-tracking.component';
import { RemindersComponent } from './components/reminders/reminders.component';
import { TimetableComponent } from './components/timetable/timetable.component';
import { NotesComponent } from './components/notes/notes.component';
import { GoalsComponent } from './components/goals/goals.component';
import { AnalyticsComponent } from './components/analytics/analytics.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CoursesComponent } from './components/courses/courses.component';
import { ViewGradeComponent } from './components/view-grade/view-grade.component';
import { StudentDashboardComponent } from './student-dashboard/student-dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


export const routes: Routes = [
  { path: '', component:LoginComponent, pathMatch: 'full' },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'student-dashboard',
    component:StudentDashboardComponent
  },
  {
    path:'courses',
    component:CoursesComponent,
  },
  {
    path:'dashboard',
    component:DashboardComponent
  },
  { 
    path: 'profile',
    component: UserProfileComponent
  },
  {
    path: 'schedule',
     component: ScheduleComponent
  },
  {
    path: 'assignments', 
    component: AssignmentTrackingComponent
  },
  {
    path:'reminders',
    component:RemindersComponent
  },
  {
    path:'timetable',
    component:TimetableComponent
  },
  {
    path:'notes',
    component:NotesComponent
  },
  {
    path:'goals',
    component:GoalsComponent
  },
  {
    path:'analytics',
    component:AnalyticsComponent
  },
  {
    path:'viewgrade',
    component:ViewGradeComponent
  }

];
