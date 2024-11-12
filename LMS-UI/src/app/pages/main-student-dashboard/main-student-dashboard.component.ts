import { Component } from '@angular/core';
import { StudentDashboardComponent } from '../../component/student-component/student-dashboard/student-dashboard.component';
import { StudentHeaderComponent } from '../../component/student-component/student-header/student-header.component';
import { StudentSideBarComponent } from '../../component/student-component/student-side-bar/student-side-bar.component';
import { FooterComponent } from "../../common/footer/footer.component";

@Component({
  selector: 'app-main-student-dashboard',
  standalone: true,
  imports: [StudentHeaderComponent, StudentSideBarComponent, FooterComponent],
  templateUrl: './main-student-dashboard.component.html',
  styleUrl: './main-student-dashboard.component.css'
})
export class MainStudentDashboardComponent {

}
