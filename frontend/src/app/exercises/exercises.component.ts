import { Component, OnInit } from '@angular/core';
import {
  ExService,
  UserService,
} from '../service';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.scss']
})
export class ExercisesComponent implements OnInit {

  fooResponse = {};
  userResponse = {};
  constructor(
    private exService: ExService,
    private userService: UserService,
  ) { }

  ngOnInit() {
  }

  userId() {
    const user = this.userService.currentUser;
    return user.id + '';
  }

  makeRequest(path) {
      this.exService.getAll()
      .subscribe(res => {
        this.forgeResonseObj(this.fooResponse, res, path);
      }, err => {
        this.forgeResonseObj(this.fooResponse, err, path);
      });
  }

  makeByIdRequest(path) {
    this.exService.getByUserId(this.userId())
    .subscribe(res => {
      this.forgeResonseObj(this.userResponse, res, '/api/word-transformation/' + this.userId());
    }, err => {
      this.forgeResonseObj(this.userResponse, err, '/api/word-transformation/' + this.userId());
    });
}

  forgeResonseObj(obj, res, path) {
    obj['path'] = path;
    obj['method'] = 'GET';
    if (res.ok === false) {
      // err
      obj['status'] = res.status;
      try {
        obj['body'] = JSON.stringify(JSON.parse(res._body), null, 2);
      } catch (err) {
        console.log(res);
        obj['body'] = res.error.message;
      }
    } else {
      // 200
      obj['status'] = 200;
      obj['body'] = JSON.stringify(res, null, 2);
    }
  }

}
