import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { StudentDashboardComponent } from "./component/student-component/student-dashboard/student-dashboard.component";
import { MainStudentDashboardComponent } from "./pages/main-student-dashboard/main-student-dashboard.component";
import { FooterComponent } from "./common/footer/footer.component";
import { AdminDashboardComponent } from "./pages/admin-dashboard/admin-dashboard.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  ngOnInit(): void {
    initFlowbite();
  }
  title = 'LMS';
}
