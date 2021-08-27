import { TestBed } from '@angular/core/testing';

import { TechnologieService } from './technologie.service';

describe('TechnologieService', () => {
  let service: TechnologieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TechnologieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
