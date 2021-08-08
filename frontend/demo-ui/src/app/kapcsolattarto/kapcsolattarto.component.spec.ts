import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KapcsolattartoComponent } from './kapcsolattarto.component';

describe('KapcsolattartoComponent', () => {
  let component: KapcsolattartoComponent;
  let fixture: ComponentFixture<KapcsolattartoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KapcsolattartoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KapcsolattartoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
