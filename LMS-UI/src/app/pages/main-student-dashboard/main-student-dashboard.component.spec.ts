import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainStudentDashboardComponent } from './main-student-dashboard.component';

describe('MainStudentDashboardComponent', () => {
  let component: MainStudentDashboardComponent;
  let fixture: ComponentFixture<MainStudentDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MainStudentDashboardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainStudentDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
