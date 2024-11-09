import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Theme } from 'src/app/core/models/theme.model';
import { User } from 'src/app/core/models/user.model';
import { SessionService } from 'src/app/core/services/session.service';
import { ThemeService } from 'src/app/core/services/theme.service';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  
  userData = {
    id: 0,
    email: "",
    name: ""
  }
  
  themes!: Theme[];
  
  constructor(
    private sessionService: SessionService, 
    private userService: UserService,
    private router: Router) {}
  
    ngOnInit(): void {
      this.displayUserData();
    }
    
    submitForm() {
      this.userService.updateUser(this.userData).subscribe({
        complete: () => {
          alert("User updated");
          this.displayUserData();
        },
      error: () => alert("Update error")
    })
  }
  
  displayUserData() {
    const id = this.sessionService.getUserId();
    
    this.userService.getMe(id).subscribe({
      next: (user: User) => {
        this.userData.id = id;
        this.userData.email = user.email;
        this.userData.name = user.name;
        this.themes = user.themes;
      },
      error: () => alert("Get user error")
    })
  }

  logout() {
    this.sessionService.deleteSession();
    this.router.navigateByUrl('login');
  }
}

