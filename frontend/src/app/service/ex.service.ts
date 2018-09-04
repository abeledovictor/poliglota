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

  post(creatorId) {
    console.log(creatorId)
    let mockNewEx = {
      "author_id": Number(creatorId),
      "wt_task": [
        {
          "body": "mock body",
          "result": "mockResult",
          "word": "mockWord",
          "word_at_index": 9,
        }
      ]
    };
    return this.apiService.post(this.config.post_new_ex, mockNewEx)
  }

}