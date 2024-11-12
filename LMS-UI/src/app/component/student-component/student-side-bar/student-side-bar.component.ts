import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-student-side-bar',
  standalone: true,
  imports: [RouterLink,RouterOutlet],
  templateUrl: './student-side-bar.component.html',
  styleUrl: './student-side-bar.component.css'
})
export class StudentSideBarComponent {

}
