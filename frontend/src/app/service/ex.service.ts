import { Injectable } from '@angular/core';
import { Headers } from '@angular/http';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';
import { map } from "rxjs/operators";

@Injectable()
export class ExService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) {}

  getAll() {
    return this.apiService.get(this.config.ex_url);
  }

  getAllfilter() {
    return this.apiService.get(this.config.ex_url).pipe(
      map((data: any) => {
        console.log(data);
        return data.map(({wt_task}) => wt_task)
      })
    );
  }

  getByUserId(authorId) {
    return this.apiService.get(this.config.ex_by_author_url + '/' + authorId);
  }

  post(creatorId, exercise) {
    console.log(creatorId)
    let data = {
      "author_id": Number(creatorId),
      "wt_task": exercise.map(row => ({
        body: row.sentence.replace(/\*(?!\/)/, ''),// finds an * only if it isn't followed by a /. You can escape *'s with / example '*/'
        result: row.answer,
        word: row.word,
        word_at_index: row.sentence.search(/\*(?!\/)/),
      })),
    };
    return this.apiService.post(this.config.post_new_ex, data)
  }
}