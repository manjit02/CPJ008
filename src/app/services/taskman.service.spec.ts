import { TestBed } from '@angular/core/testing';

import { TaskmanService } from './taskman.service';

describe('TaskmanService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TaskmanService = TestBed.get(TaskmanService);
    expect(service).toBeTruthy();
  });
});
