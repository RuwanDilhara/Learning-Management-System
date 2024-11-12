import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentViewAllCoursesComponent } from './student-view-all-courses.component';

describe('StudentViewAllCoursesComponent', () => {
  let component: StudentViewAllCoursesComponent;
  let fixture: ComponentFixture<StudentViewAllCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentViewAllCoursesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentViewAllCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
