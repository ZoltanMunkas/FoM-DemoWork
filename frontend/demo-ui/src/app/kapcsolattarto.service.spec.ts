import { TestBed } from '@angular/core/testing';

import { KapcsolattartoService } from './kapcsolattarto.service';

describe('KapcsolattartoService', () => {
  let service: KapcsolattartoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KapcsolattartoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
