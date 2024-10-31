import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerData = {
    email: "",
    username: "",
    password: ""
  };

  ngOnInit(): void {
  }

  submitForm() {
    throw new Error('Method not implemented.');
  }

}
