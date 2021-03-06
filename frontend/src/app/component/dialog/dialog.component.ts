import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

export interface DialogData {
    animal: string;
    name: string;
  }

@Component({
    selector: 'dialog-component',
    templateUrl: 'dialog.component.html',
  })
  export class DialogOverviewExampleDialog {
    choices = [''];
    constructor(
      public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
      @Inject(MAT_DIALOG_DATA) public data: DialogData) {}
  
    onNoClick(): void {
      this.dialogRef.close();
    }
  
  }