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
    // this.optionPopup.options.push({ selectionStart,selectionEnd, choices:[] });

    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '400px',
      height: '400px',
      data: { selectedWord, selectionStart, selectionEnd, optionPopup: this.optionPopup }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      this.optionPopup.options.push(result)
    });
  }

  wordTransformationPost() {

    console.log(this.wordTransformations);

for (let count = 0 ; count < this.wordTransformations.length ; count++){
  if (this.wordTransformations[count].sentence === '' || this.wordTransformations[count].answer === '') {
    console.log(`Error: Word Transformation not valid!`);
    console.log(this.wordTransformations[count]);
    var deleteword = this.wordTransformations.splice(count, 1);
    console.log(deleteword);
  }else{
    let temp:string = this.wordTransformations[count].sentence;
    if (temp.includes('*')) {
      console.log('Valid word transformation!');
    }else {
      console.log(`Error: No content *.`);
      deleteword = this.wordTransformations.splice(count, 1);
    }
  }
}
console.log(this.wordTransformations);
      this.exService.post(this.userId(), this.wordTransformations)
      .subscribe(res => {
        console.log(res)
      }, err => {
        console.log(err)
      });
  }
}