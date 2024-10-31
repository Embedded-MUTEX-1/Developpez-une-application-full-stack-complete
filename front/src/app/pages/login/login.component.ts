import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Auth } from 'src/app/core/models/auth.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginData = {
    email: "",
    password: ""
  };
  
  ngOnInit(): void {
    
  }
  
  submitForm() {
    throw new Error('Method not implemented.');
  }
}
