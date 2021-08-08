import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KapcsolattartoDetailComponent } from './kapcsolattarto-detail.component';

describe('KapcsolattartoDetailComponent', () => {
  let component: KapcsolattartoDetailComponent;
  let fixture: ComponentFixture<KapcsolattartoDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KapcsolattartoDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KapcsolattartoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
