import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service';


@Component({
  selector: 'exercises-menu',
  templateUrl: './exercises-menu.component.html',
  styleUrls: ['./exercises-menu.component.scss']
})
export class ExercisesMenuComponent implements OnInit {

  constructor(
    private userService: UserService
  ) {}

  ngOnInit() {

  }

  isAllowed(): boolean {
    const isAdmin = this.userService.currentUser && this.userService.currentUser.authorities.find(({authority}) => authority === 'ROLE_ADMIN');
    if (isAdmin) { return true; }
    return false;
  }

}
