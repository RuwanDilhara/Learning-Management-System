import { Routes } from '@angular/router';
import { StudentDashboardComponent } from './component/student-component/student-dashboard/student-dashboard.component';
import { MainStudentDashboardComponent } from './pages/main-student-dashboard/main-student-dashboard.component';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { StudentViewAllCoursesComponent } from './component/student-component/student-view-all-courses/student-view-all-courses.component';
import { StudentMyCourseComponent } from './component/student-component/student-my-course/student-my-course.component';
import { StudentGradeComponent } from './component/student-component/student-grade/student-grade.component';
import { StudentAssignmentComponent } from './component/student-component/student-assignment/student-assignment.component';
import { StudentRemindersComponent } from './component/student-component/student-reminders/student-reminders.component';
import { StudentViewGoalComponent } from './component/student-component/student-view-goal/student-view-goal.component';
import { StudentAnalyticsComponent } from './component/student-component/student-analytics/student-analytics.component';
import { LoginFormComponent } from './pages/login-form/login-form.component';
import { RegisterFormComponent } from './pages/register-form/register-form.component';
import { HomePageComponent } from './pages/home-page/home-page.component';

export const routes: Routes = [
    {path:'',redirectTo:'homepage',pathMatch:'full'},
    {
        path:'student',
        component:MainStudentDashboardComponent,
        children:[
            {path:'',redirectTo:'dashboard',pathMatch:'full'},
            {
                path:'dashboard',
                component:StudentDashboardComponent
                
            },
            {
                path:'all-courses',
                component:StudentViewAllCoursesComponent
                
            },
            {
                path:'my-courses',
                component:StudentMyCourseComponent
                
            },
            {
                path:'grade',
                component:StudentGradeComponent
                
            },
            {
                path:'assignment',
                component:StudentAssignmentComponent

            },
            {
                path:'reminders',
                component:StudentRemindersComponent

            },
            {
                path:'goal',
                component:StudentViewGoalComponent

            },
            {
                path:'analiytics',
                component:StudentAnalyticsComponent              
            }
        ]
    },
    {
        path:'login',
        component:LoginFormComponent
    },
    {
        path:'register',
        component:RegisterFormComponent
    },
    {
        path:'homepage',
        component:HomePageComponent,
        children:[
            {
                path:'all-courses',
                component:StudentViewAllCoursesComponent
            }
        ]
    }
];
