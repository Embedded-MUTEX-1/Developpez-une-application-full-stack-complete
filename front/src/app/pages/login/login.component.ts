import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from 'src/app/core/models/auth.model';
import { AuthService } from 'src/app/core/services/auth.service';
import { SessionService } from 'src/app/core/services/session.service';

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

  constructor(private authService: AuthService, private sessionService: SessionService , private router: Router) {}
  
  ngOnInit(): void {
    
  }
  
  submitForm() {
    this.authService.login(this.loginData).subscribe({
      next: (resp) => {
        this.sessionService.setUserId(resp.id);
        this.sessionService.setToken(resp.token);
        this.router.navigateByUrl('articles')
      },
      error: () => alert("Auth failed")
    })
  }
}
