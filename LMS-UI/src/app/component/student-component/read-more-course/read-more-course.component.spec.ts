import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadMoreCourseComponent } from './read-more-course.component';

describe('ReadMoreCourseComponent', () => {
  let component: ReadMoreCourseComponent;
  let fixture: ComponentFixture<ReadMoreCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReadMoreCourseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReadMoreCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
