import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentViewGoalComponent } from './student-view-goal.component';

describe('StudentViewGoalComponent', () => {
  let component: StudentViewGoalComponent;
  let fixture: ComponentFixture<StudentViewGoalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentViewGoalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentViewGoalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
