import { Component, OnInit } from '@angular/core';
import {
  FooService,
  ConfigService,
  UserService,
  ExService,
} from '../service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  fooResponse = {};
  whoamIResponse = {};
  allUserResponse = {};
  getAllResponse = {};
  userResponse = {};
  postRequestResponse = {};
  constructor(
    private config: ConfigService,
    private fooService: FooService,
    private userService: UserService,
    private exService: ExService,
  ) { }

  ngOnInit() {
  }

  userId() {
    const user = this.userService.currentUser;
    return user.id + '';
  }

  makeByIdRequest(path) {
    this.exService.getByUserId(this.userId())
    .subscribe(res => {
      this.forgeResonseObj(this.userResponse, res, '/api/word-transformation/' + this.userId());
    }, err => {
      this.forgeResonseObj(this.userResponse, err, '/api/word-transformation/' + this.userId());
    });
}

  makeExercisePost() {
    this.exService.post(this.userId())
    .subscribe(res => {
      this.forgeResonseObj(this.postRequestResponse, res, '/api/word-transformation/new')
    }, err => {
      this.forgeResonseObj(this.postRequestResponse, err, '/api/word-transformation/new')
    });
  }

  makegetAllRequest(path) {
    this.exService.getAll()
    .subscribe(res => {
      this.forgeResonseObj(this.getAllResponse, res, path);
    }, err => {
      this.forgeResonseObj(this.getAllResponse, err, path);
    });
}

  makeRequest(path) {
    if (path === this.config.foo_url) {
      this.fooService.getFoo()
      .subscribe(res => {
        this.forgeResonseObj(this.fooResponse, res, path);
      }, err => {
        this.forgeResonseObj(this.fooResponse, err, path);
      });
    } else if (path === this.config.whoami_url) {
      this.userService.getMyInfo()
      .subscribe(res => {
        this.forgeResonseObj(this.whoamIResponse, res, path);
      }, err => {
        this.forgeResonseObj(this.whoamIResponse, err, path);
      });
    } else {
      this.userService.getAll()
      .subscribe(res => {
        this.forgeResonseObj(this.allUserResponse, res, path);
      }, err => {
        this.forgeResonseObj(this.allUserResponse, err, path);
      });
    }
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
