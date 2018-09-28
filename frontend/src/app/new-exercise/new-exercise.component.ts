import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DialogOverviewExampleDialog } from 'app/component/dialog';
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
  optionPicker = [];
  optionPopup = {text: '', options: []};
  constructor(
    private exService: ExService,
    private userService: UserService,
    public dialog: MatDialog,
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

  optionPickerSelectHandler(ev) {
    const { selectionStart, selectionEnd, value: string } = ev.target;
    const selectedWord = string.slice(selectionStart, selectionEnd);
    this.optionPopup.text = string;
    this.optionPopup.options.push({ selectionStart,selectionEnd, choices:[] });

    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '400px',
      height: '400px',
      // data: {name: this.name, animal: this.animal}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
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
