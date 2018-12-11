import { Component, OnInit } from '@angular/core';
import {
  FooService,
  ConfigService,
  UserService,
  ExService,
} from '../service';
import { pipe } from 'rxjs';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.scss']
})
export class ExercisesComponent implements OnInit {

  response = [];

  constructor(
    private exService: ExService
  ) { }


  getAllEx() {
    this.exService.getAllfilter()
      .subscribe((data: any) => {
        // console.log(data);
        this.response = data;

        // Cambio el string del body por uno que contiene una cadena de puntos en donde se debe insertar la palabra.
        for (let count = 0 ; count < this.response.length ; count++) {
           let temp: string = this.response[count].body
           this.response[count].body = temp.slice(0,this.response[count].word_at_index) + "....." + temp.slice(this.response[count].word_at_index,temp.length);
        }
          // console.log(this.response);
      });
  }

  ngOnInit() {
    this.getAllEx();
  }
}