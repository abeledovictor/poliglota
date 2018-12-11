import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseModelComponent } from './exercise-model.component';

describe('ExerciseModelComponent', () => {
  let component: ExerciseModelComponent;
  let fixture: ComponentFixture<ExerciseModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExerciseModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExerciseModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
