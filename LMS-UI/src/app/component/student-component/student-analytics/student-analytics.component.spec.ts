import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentAnalyticsComponent } from './student-analytics.component';

import { Chart } from 'chart.js';

describe('StudentAnalyticsComponent', () => {
  let component: StudentAnalyticsComponent;
  let fixture: ComponentFixture<StudentAnalyticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentAnalyticsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentAnalyticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
