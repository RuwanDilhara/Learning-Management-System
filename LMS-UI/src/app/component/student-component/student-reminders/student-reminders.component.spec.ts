import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentRemindersComponent } from './student-reminders.component';

describe('StudentRemindersComponent', () => {
  let component: StudentRemindersComponent;
  let fixture: ComponentFixture<StudentRemindersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentRemindersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentRemindersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
