import { Injectable } from '@angular/core';
import { Headers } from '@angular/http';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';

@Injectable()
export class ExService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) { }

  getAll() {
    return this.apiService.get(this.config.ex_url);
  }

  getByUserId(authorId) {
    return this.apiService.get(this.config.ex_by_author_url + '/' + authorId);
  }

}