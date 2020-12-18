import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AltertsComponent } from './alterts.component';

describe('AltertsComponent', () => {
  let component: AltertsComponent;
  let fixture: ComponentFixture<AltertsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AltertsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AltertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
