import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignmentTrackingComponent } from './assignment-tracking.component';

describe('AssignmentTrackingComponent', () => {
  let component: AssignmentTrackingComponent;
  let fixture: ComponentFixture<AssignmentTrackingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssignmentTrackingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignmentTrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
