import { Component, AfterViewInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';

@Component({
  selector: 'app-student-analytics',
  standalone: true,
  imports: [],
  templateUrl: './student-analytics.component.html',
  styleUrls: ['./student-analytics.component.css']
})
export class StudentAnalyticsComponent implements AfterViewInit {

  ngAfterViewInit(): void {
    this.createChart();
  }

  createChart(): void {
    // Register the chart.js components
    Chart.register(...registerables);

    const ctx = document.getElementById('student-analytics-chart') as HTMLCanvasElement;

    if (!ctx) {
      console.error('Canvas element not found!');
      return;
    }

    // Creating the chart
    new Chart(ctx, {
      type: 'bar', // Example chart type, you can change it
      data: {
        labels: ['Math', 'English', 'Science', 'History', 'Geography'], // Example subjects
        datasets: [{
          label: 'Student Scores',
          data: [75, 88, 92, 65, 70], // Example data
          borderColor: '#4CAF50',
          backgroundColor: 'rgba(76, 175, 80, 0.2)',
          borderWidth: 2,
        }]
      },
      options: {
        responsive: true,
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }
}
