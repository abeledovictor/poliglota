import { Component, OnInit } from '@angular/core';
import {
  ExService,
  UserService,
} from '../service';

@Component({
  selector: 'new-exercise',
  templateUrl: './new-exercise.component.html',
  styleUrls: ['./new-exercise.component.scss']
})
export class NewExerciseComponent implements OnInit {

  wordTransformations = [];
  constructor(
    private exService: ExService,
    private userService: UserService,
  ) { }

  ngOnInit() {
    this.wordTransformations.push({sentence: '', word: '', answer: ''});
  }

  userId() {
    const user = this.userService.currentUser;
    return user.id + '';
  }

  onAddClick() {
    this.wordTransformations.push({sentence: '', word: '', answer: ''});
  }

  isLast(index) {
    if(index === this.wordTransformations.length - 1) {
      return true;
    } else {
      return false;
    }
  }

  wordTransformationPost() {
    this.exService.post(this.userId(), this.wordTransformations)
    .subscribe(res => {
      console.log(res)
    }, err => {
      console.log(err)
    });
  }
}