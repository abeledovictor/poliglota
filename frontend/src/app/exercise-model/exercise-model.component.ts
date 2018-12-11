import { Component, OnInit, Input } from '@angular/core';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';

@Component({
  selector: 'app-exercise-model',
  templateUrl: './exercise-model.component.html',
  styleUrls: ['./exercise-model.component.scss']
})
export class ExerciseModelComponent implements OnInit {

  @Input() item: any = [];
  @Input() i: any = [];

  constructor() { }

  saveValue(valueUser, value) {
    if (valueUser === value) {
      console.log('Correct!');
      document.getElementById(`good${this.i + 1}`).style.display = 'inline';
      document.getElementById(`wrong${this.i + 1}`).style.display = 'none';
      console.log(`good${this.i + 1}`);
    }else {
      console.log('Wrong!');
      console.log(`good${this.i + 1}`);
      document.getElementById(`good${this.i + 1}`).style.display = 'none';
      document.getElementById(`wrong${this.i + 1}`).style.display = 'inline';
    }
  }

  ngOnInit() {}

}