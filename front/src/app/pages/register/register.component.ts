import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/services/user.service';

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

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
  }

  submitForm() {
    this.userService.register(this.registerData).subscribe({
      complete: () => {
        alert('Account created');
        this.router.navigateByUrl('login');
      },
      error: () => alert('Register Error')
    })
  }

}
