import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogsFormsComponent } from './logs-forms.component';

describe('LogsFormsComponent', () => {
  let component: LogsFormsComponent;
  let fixture: ComponentFixture<LogsFormsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogsFormsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogsFormsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
